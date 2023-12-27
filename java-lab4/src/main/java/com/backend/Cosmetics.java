package com.backend;

public class Cosmetics {
    private String brand;
    private String productType;
    private double price;
    int quantity;
    private String gender;

    public Cosmetics(String brand, String productType, double price, int quantity, String gender) {
        this.brand = brand;
        this.productType = productType;
        this.price = price;
        this.quantity = quantity;
        this.gender = gender;
    }

    public String getBrand() {
        return brand;
    }

    public String getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getGender() {
        return gender;
    }
}
