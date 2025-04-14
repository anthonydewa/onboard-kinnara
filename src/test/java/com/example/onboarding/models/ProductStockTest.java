package com.example.onboarding.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductStockTest {
    @Test
    @DisplayName("ProductStock Setter & Getter Test")
    void ProductStockSetGetTest() {
        ProductStock productStock = new ProductStock();

        productStock.setStorageBin$_identifier("XYZ");
        Assertions.assertEquals("XYZ", productStock.getStorageBin$_identifier());

        productStock.setProduct("xxyyzz");
        Assertions.assertEquals("xxyyzz", productStock.getProduct());

        productStock.setProduct$_identifier("Product 1");
        Assertions.assertEquals("Product 1", productStock.getProduct$_identifier());

        productStock.setuOM("100");
        Assertions.assertEquals("100", productStock.getuOM());

        productStock.setuOM$_identifier("Unit");
        Assertions.assertEquals("Unit", productStock.getuOM$_identifier());

        productStock.setStorageBin("aabbcc");
        Assertions.assertEquals("aabbcc", productStock.getStorageBin());

        productStock.setQuantityOnHand("40");
        Assertions.assertEquals("40", productStock.getQuantityOnHand());

        productStock.set_id("back");
        Assertions.assertEquals("back", productStock.get_id());
    }

    @Test
    @DisplayName("ProductStock Construct with parameters")
    void ProductStockConstructorParameterTest() {
        ProductStock productStock = new ProductStock("XYZ", "Product 1", "40");

        Assertions.assertEquals("XYZ", productStock.getStorageBin$_identifier());
        Assertions.assertEquals("Product 1", productStock.getProduct$_identifier());
        Assertions.assertEquals("40", productStock.getQuantityOnHand());
    }

    @Test
    @DisplayName("ProductStock To String Output")
    void ProductStockToString() {
        ProductStock productStock = new ProductStock();

        Assertions.assertNull(productStock.toString());

        productStock.set_id("back");
        Assertions.assertEquals("back", productStock.toString());
    }
}
