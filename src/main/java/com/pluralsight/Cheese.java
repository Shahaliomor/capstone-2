package com.pluralsight;

public class Cheese extends Topping implements PriceItem {
    private double price;

    public Cheese(String name, double price) {
        super(name);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
