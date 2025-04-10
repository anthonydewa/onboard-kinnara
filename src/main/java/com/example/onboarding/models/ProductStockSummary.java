package com.example.onboarding.models;

public class ProductStockSummary {
    private String storageBin$_identifier;
    private String formattedProduct$_identifier;
    private Long totalQuantity;

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getFormattedProduct$_identifier() {
        return formattedProduct$_identifier;
    }

    public void setFormattedProduct$_identifier(String formattedProduct$_identifier) {
        this.formattedProduct$_identifier = formattedProduct$_identifier;
    }

    public String getStorageBin$_identifier() {
        return storageBin$_identifier;
    }

    public void setStorageBin$_identifier(String storageBin$_identifier) {
        this.storageBin$_identifier = storageBin$_identifier;
    }
}
