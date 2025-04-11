package com.example.onboarding.httpmodelresponses;

import com.example.onboarding.models.ProductStock;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductStockResponse {
    @JsonProperty("digest")
    private String digest;

    @JsonProperty("total")
    private int total;

    @JsonProperty("data")
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
