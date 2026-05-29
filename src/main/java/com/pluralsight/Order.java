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
    //get method
    public String getName() {
        return name;
    }
    //Add in Arraylist
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
    public double getTotalPrice() {
        double total = 0;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }

        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        for (Chips chip : chips) {
            total += chip.getPrice();
        }

        return total;
    }
}
