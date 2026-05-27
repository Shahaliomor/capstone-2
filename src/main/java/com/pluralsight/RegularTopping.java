package com.pluralsight;

public class RegularTopping extends Topping implements PriceItem {

    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return 0;
    }
}