package com.pluralsight;

import java.util.ArrayList;

public class Order {
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drink> drinks;
    private ArrayList<Chips> chips;
    private String name;
    //Constructor for Order class.
    public Order(String name) {
        this.name = name;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();

    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public String getName() {
        return name;
    }

    public void addSandwich(Sandwich sandwich) {
        this.sandwiches.add(sandwich);
    }
    public ArrayList<Drink> getDrinks() {
        return drinks;
    }
    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }
    public ArrayList<Chips> getChips() {
        return chips;
    }
    public void addChip(Chips chip) {
        this.chips.add(chip);
    }

}
