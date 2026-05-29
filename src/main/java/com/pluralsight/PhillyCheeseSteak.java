package com.pluralsight;

public class PhillyCheeseSteak extends Sandwich {

    public PhillyCheeseSteak() {
        super(8, "White", true);

        addTopping(new Meat("Steak", 2.00));
        addTopping(new Cheese("American", 1.50));
        addTopping(new RegularTopping("Peppers"));
        addTopping(new Sauce("Mayo"));
    }
}