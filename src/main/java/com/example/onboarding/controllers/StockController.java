package com.example.onboarding.controllers;

import com.example.onboarding.models.ProductStockSummary;
import com.example.onboarding.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    public StockService stockService;

    @GetMapping("/summary")
    public ResponseEntity<List<ProductStockSummary>> StockSummary() {
        List<ProductStockSummary> data = stockService.StockSummary();

        return new ResponseEntity<>(data, HttpStatusCode.valueOf(200));
    }
}
