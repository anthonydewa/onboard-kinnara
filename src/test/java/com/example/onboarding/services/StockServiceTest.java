package com.example.onboarding.services;

import com.example.onboarding.models.ProductStock;
import com.example.onboarding.models.ProductStockExternalResponse;
import com.example.onboarding.models.ProductStockSummary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class StockServiceTest {
    @Mock
    private RestClient.Builder builder;

    @Mock
    private RestClient restClient;

    @Mock
    private RestClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private  RestClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private RestClient.ResponseSpec responseSpec;

    @Autowired
    private StockService stockService;

    @Test
    @DisplayName("Test stock summary service")
    void stockSummaryService() {
        String productStockUrl = "https://sandbox.kecak.org/web/json/data/app/emkfast/datalist/productStock";
        ProductStockExternalResponse productStockExternalResponse = getProductStockExternalResponse();

        try (MockedStatic<RestClient> mocked = mockStatic(RestClient.class)) {
            mocked.when(RestClient::builder).thenReturn(builder);
            when(builder.build()).thenReturn(restClient);
            when(restClient.get()).thenReturn(requestHeadersUriSpec);
            when(requestHeadersUriSpec.uri(productStockUrl)).thenReturn(requestHeadersSpec);
            when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
            when(responseSpec.body(ProductStockExternalResponse.class)).thenReturn(productStockExternalResponse);


            List<ProductStockSummary> result = stockService.stockSummary();
            Assertions.assertEquals(2, result.size());
        }
    }

    @Test
    @DisplayName("Test stock summary service external API return is null")
    void stockSummaryServiceNullExternalAPI() {
        String productStockUrl = "https://sandbox.kecak.org/web/json/data/app/emkfast/datalist/productStock";
        try (MockedStatic<RestClient> mocked = mockStatic(RestClient.class)) {
            mocked.when(RestClient::builder).thenReturn(builder);
            when(builder.build()).thenReturn(restClient);
            when(restClient.get()).thenReturn(requestHeadersUriSpec);
            when(requestHeadersUriSpec.uri(productStockUrl)).thenReturn(requestHeadersSpec);
            when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
            when(responseSpec.body(ProductStockExternalResponse.class)).thenReturn(null);

            List<ProductStockSummary> result = stockService.stockSummary();
            Assertions.assertEquals(0, result.size());
        }
    }

    private static ProductStockExternalResponse getProductStockExternalResponse() {
        ProductStockExternalResponse productStockExternalResponse = new ProductStockExternalResponse();

        ProductStock productStock1 = new ProductStock(
                "Bin A",
                "2025-Product 1 30mg 15ml",
                "45"
        );
        ProductStock productStock2 = new ProductStock(
                "Bin A",
                "2025-Product 1 7mg 8ml",
                "100"
        );
        ProductStock productStock3 = new ProductStock(
                "Bin B",
                "2025-Product 1 30mg 15ml",
                "70"
        );


        productStockExternalResponse.setTotal(3);
        productStockExternalResponse.setDigest("digest");
        productStockExternalResponse.setData(Arrays.asList(productStock1, productStock2, productStock3));
        return productStockExternalResponse;
    }
}
