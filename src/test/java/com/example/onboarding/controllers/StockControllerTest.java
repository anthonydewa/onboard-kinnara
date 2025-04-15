package com.example.onboarding.controllers;

import com.example.onboarding.models.ProductStockSummary;
import com.example.onboarding.services.StockService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StockControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private StockService service;

    @Test
    @DisplayName("GET /stock/summary - 200 OK")
    void stockSummaryTest() throws Exception {
        ProductStockSummary summary1 = new ProductStockSummary("XYZ", "Product 1", 123L);
        ProductStockSummary summary2 = new ProductStockSummary("ABC", "Product 2", 99L);
        when(service.StockSummary()).thenReturn(Arrays.asList(summary1, summary2));

        mockMvc.perform(get("/stock/summary"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].storageBin$_identifier").value("XYZ"))
                .andExpect(jsonPath("$[0].formattedProduct$_identifier").value("Product 1"))
                .andExpect(jsonPath("$[0].totalQuantity").value(123L))
                .andExpect(jsonPath("$[1].storageBin$_identifier").value("ABC"))
                .andExpect(jsonPath("$[1].formattedProduct$_identifier").value("Product 2"))
                .andExpect(jsonPath("$[1].totalQuantity").value(99L));
    }
}
