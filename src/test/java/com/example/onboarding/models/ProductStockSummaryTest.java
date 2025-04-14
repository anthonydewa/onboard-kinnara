package com.example.onboarding.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductStockSummaryTest {
    @Test
    @DisplayName("ProductStockSummary Setter & Getter Test")
    void ProductStockSummarySetGetTest() {
        ProductStockSummary productStockSummary = new ProductStockSummary();

        productStockSummary.setStorageBin$_identifier("XYZ");
        Assertions.assertEquals("XYZ", productStockSummary.getStorageBin$_identifier());

        productStockSummary.setFormattedProduct$_identifier("Product 1");
        Assertions.assertEquals("Product 1", productStockSummary.getFormattedProduct$_identifier());

        productStockSummary.setTotalQuantity(343L);
        Assertions.assertEquals(343, productStockSummary.getTotalQuantity());

    }

    @Test
    @DisplayName("ProductStockSummary Construct with parameters")
    void ProductStockSummaryConstructorParameterTest() {
        ProductStockSummary productStockSummary = new ProductStockSummary("XYZ", "Product 1", 343L);

        Assertions.assertEquals("XYZ", productStockSummary.getStorageBin$_identifier());
        Assertions.assertEquals("Product 1", productStockSummary.getFormattedProduct$_identifier());
        Assertions.assertEquals(343, productStockSummary.getTotalQuantity());
    }

    @Test
    @DisplayName("ProductStockSummary To String Output")
    void ProductStockSummaryToString() {
        ProductStockSummary productStockSummary = new ProductStockSummary("XYZ", "Product 1", 343L);

        Assertions.assertEquals("XYZProduct 1", productStockSummary.toString());
    }
}
