package com.pluralsight;

public class Meat extends Topping implements PriceItem{
    private double price;
    public Meat(String name, double price){
        super(name);
        this.price=price;
    }
    @Override
    public double getPrice() {
        return price;
    }

}
