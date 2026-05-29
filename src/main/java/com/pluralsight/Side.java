package com.pluralsight;

public class Side extends Topping implements PriceItem {

    public Side(String name) {
        super(name);
    }
    // Regular side do not have an extra charge.
    @Override
    public double getPrice() {
        return 0;
    }
}