package com.example.onboarding.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ProductStockExternalResponseTest {
    @Test
    @DisplayName("ProductStock Setter & Getter Test")
    void ProductStockExternalResponseSetGetTest() {
        ProductStockExternalResponse productStockExternalResponse = new ProductStockExternalResponse();

        productStockExternalResponse.setDigest("xxx");
        Assertions.assertEquals("xxx", productStockExternalResponse.getDigest());

        productStockExternalResponse.setTotal(1000);
        Assertions.assertEquals(1000, productStockExternalResponse.getTotal());

        productStockExternalResponse.setData(new ArrayList<>());
        Assertions.assertEquals(0, productStockExternalResponse.getData().size());
    }
}
