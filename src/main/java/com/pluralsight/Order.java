package com.pluralsight;

import java.util.ArrayList;

public class Order {
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drink> drinks;
    private ArrayList<Chips> chips;
    //Constructor for Order class.
    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
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
