package com.example.onboarding.models;

import java.util.List;

/* API endpoint response class */
public class ProductStockExternalResponse {
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
