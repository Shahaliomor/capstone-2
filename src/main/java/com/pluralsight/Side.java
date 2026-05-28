package com.pluralsight;

public class Side extends Topping implements PriceItem {

    public Side(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return 0;
    }
}