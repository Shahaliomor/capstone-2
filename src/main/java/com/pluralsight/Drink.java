package com.pluralsight;

public class Drink implements PriceItem {

    private String size;
    private double price;

    public Drink(String size, double price) {
        this.size = size;
        this.price = price;
    }

    public String getSize() {
        return size;
    }
    // Regular drink with an extra charge.
    @Override
    public double getPrice() {
        return price;
    }
}