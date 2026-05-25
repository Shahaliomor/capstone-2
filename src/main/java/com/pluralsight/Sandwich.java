package com.pluralsight;

import java.util.ArrayList;

public class Sandwich {
    private int size;
    private String bread;
    private boolean toasted = false;
    private ArrayList<Topping> toppings;
    private ArrayList<Sandwich> sandwiches;
    private boolean extraToppings = false;
    private boolean extraCheese = false;
    private boolean regularToppings = false;
    private boolean Cheese = false;
    private String cheese;
    private ArrayList<Sandwich> extraSandwiches;
    public Sandwich(int size, String bread,
                    boolean toasted, boolean extraToppings,
                    boolean Cheese, boolean extraCheese) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.sandwiches = new ArrayList<Sandwich>();

    }
}
