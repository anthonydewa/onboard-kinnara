package com.example.onboarding.services;

import com.example.onboarding.models.ProductStock;
import com.example.onboarding.models.ProductStockExternalResponse;
import com.example.onboarding.models.ProductStockSummary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StockService {
    public List<ProductStockSummary> StockSummary() {
        /*Get JSON data from API endpoint*/
        String productStockUrl = "https://sandbox.kecak.org/web/json/data/app/emkfast/datalist/productStock";
        RestClient restClient = RestClient.builder().build();

        ProductStockExternalResponse productStockExternalResponse = restClient.get().uri(productStockUrl).retrieve().body(ProductStockExternalResponse.class);

        List<ProductStock> productStocks;
        if (productStockExternalResponse != null) {
            productStocks = productStockExternalResponse.getData();
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
