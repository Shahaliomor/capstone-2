package com.pluralsight;

import java.util.ArrayList;

public class Sandwich implements PriceItem {
    private int size;
    private String bread;
    private boolean toasted;
    private ArrayList<Topping> toppings;
    //Construction
    public Sandwich(int size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }
    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public int getSize() {
        return size;
    }

    public String getBread() {
        return bread;
    }

    public boolean isToasted() {
        return toasted;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
    //get price depend on size.
    @Override
    public double getPrice() {
        double price = 0;

        if (size == 4) {
            price = 5.50;
        } else if (size == 8) {
            price = 7.00;
        } else if (size == 12) {
            price = 8.50;
        }

        for (Topping topping : toppings) {
            if (topping instanceof PriceItem) {
                price += ((PriceItem) topping).getPrice();
            }
        }

        return price;
    }
}
