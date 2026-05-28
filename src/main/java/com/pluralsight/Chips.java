package com.pluralsight;

public class Chips implements PriceItem {

    private double price;

    public Chips(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}