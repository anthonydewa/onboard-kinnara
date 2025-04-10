package com.example.onboarding.services;

import com.example.onboarding.models.ProductStock;
import com.example.onboarding.models.ProductStockSummary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* API endpoint response class */
class ProductStockResponse {
    private String digest;
    private int total;
    private List<ProductStock> data;

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ProductStock> getData() {
        return data;
    }

    public void setData(List<ProductStock> data) {
        this.data = data;
    }
}

@Service
public class StockService {
    public List<ProductStockSummary> StockSummary() {
        /*Get JSON data from API endpoint*/
        String productStockUrl = "https://sandbox.kecak.org/web/json/data/app/emkfast/datalist/productStock";
        RestClient restClient = RestClient.builder().build();

        ProductStockResponse productStockResponse = restClient.get().uri(productStockUrl).retrieve().body(ProductStockResponse.class);

        List<ProductStock> productStocks;
        if (productStockResponse != null) {
            productStocks = productStockResponse.getData();
        } else {
            productStocks = new ArrayList<>();
        }

        /* Standardize product identifier & group by */
        Map<List<String>, List<ProductStock>> groupedProductStocks = productStocks.stream().peek(e -> {
            String formattedProductIdentifier = e.getProduct$_identifier()
                    .replaceAll("^([0-9]{4}-)", "") /* Matching Prefix Year */
                    .replaceAll("\\d*(ml|mg|g|gr|kg|l|cl|dl|mm|cm|m|km|oz|lb|\\[DP])", "") /* Matching Metric */
                    .trim();
            e.setProduct$_identifier(formattedProductIdentifier);
        }).collect(Collectors.groupingBy(e -> List.of(e.getStorageBin$_identifier(), e.getProduct$_identifier())));

        /* Initiate Result objs & sum quantity */
        List<ProductStockSummary> rslt = new ArrayList<>();

        groupedProductStocks.forEach((groupKey, groupRslt) -> {
            String groupStorageBinId = groupKey.get(0);
            String groupProductId = groupKey.get(1);
            
            ProductStockSummary productStockSummary;
            productStockSummary = new ProductStockSummary();
            productStockSummary.setStorageBin$_identifier(groupStorageBinId);
            productStockSummary.setFormattedProduct$_identifier(groupProductId);

            /* get sum quantity from grouped result */
            Long totQuant = groupRslt.stream()
                    .map(ProductStock::getQuantityOnHand)
                    .map(Long::parseLong)
                    .reduce(0L, Long::sum);

            productStockSummary.setTotalQuantity(totQuant);

            rslt.add(productStockSummary);
        });

        return rslt;
    }
}
