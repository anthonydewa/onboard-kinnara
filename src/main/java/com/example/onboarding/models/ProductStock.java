package com.example.onboarding.models;

public class ProductStock {
    private String storageBin$_identifier;
    private String product;
    private String product$_identifier;
    private String uOM;
    private String uOM$_identifier;
    private String storageBin;
    private String quantityOnHand;
    private String _id;

    public ProductStock(String storageBin$_identifier, String product$_identifier, String quantityOnHand) {
        this.storageBin$_identifier = storageBin$_identifier;
        this.product$_identifier = product$_identifier;
        this.quantityOnHand = quantityOnHand;
    }

    public ProductStock() {
    }

    public String getStorageBin$_identifier() {
        return storageBin$_identifier;
    }

    public void setStorageBin$_identifier(String storageBin$_identifier) {
        this.storageBin$_identifier = storageBin$_identifier;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct$_identifier() {
        return product$_identifier;
    }

    public void setProduct$_identifier(String product$_identifier) {
        this.product$_identifier = product$_identifier;
    }

    public String getuOM() {
        return uOM;
    }

    public void setuOM(String uOM) {
        this.uOM = uOM;
    }

    public String getuOM$_identifier() {
        return uOM$_identifier;
    }

    public void setuOM$_identifier(String uOM$_identifier) {
        this.uOM$_identifier = uOM$_identifier;
    }

    public String getStorageBin() {
        return storageBin;
    }

    public void setStorageBin(String storageBin) {
        this.storageBin = storageBin;
    }

    public String getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(String quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return this._id;
    }
}
