package com.pluralsight;

public class RegularTopping extends Topping implements PriceItem {
    // Creates a regular topping with the specified name.
    public RegularTopping(String name) {
        super(name);
    }
    // Regular toppings do not have an extra charge.
    @Override
    public double getPrice() {
        return 0;
    }
}