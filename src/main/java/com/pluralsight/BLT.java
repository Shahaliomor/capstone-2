package com.pluralsight;

public class BLT extends Sandwich {
    // Creates a pre-configured BLT sandwich with default toppings.
    public BLT() {

        super(8, "White", true);

        addTopping(new Meat("Bacon", 2.00));
        addTopping(new Cheese("Cheddar", 1.50));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Tomatoes"));
        addTopping(new Sauce("Ranch"));
    }
}