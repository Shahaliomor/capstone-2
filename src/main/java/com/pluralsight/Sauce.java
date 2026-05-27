package com.pluralsight;

public class Sauce extends Topping implements PriceItem {

    public Sauce(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return 0;
    }
}