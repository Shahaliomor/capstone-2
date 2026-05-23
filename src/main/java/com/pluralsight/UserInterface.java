package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Order currentOrder;
    public static Scanner input = new Scanner(System.in);
    public void displayHomeScreen(){
        System.out.println("""
                1) New Order
                0) Exit - exit the application
                """);

        int choice = input.nextInt();
        if(choice == 1){
            System.out.println("Welcome to CHEESY BURG!");
            displayOrderScreen();
        }
        else if(choice == 0) {
            return;
        }
        else{
            System.out.println("Invalid choice. Try again.");
            displayHomeScreen();
        }


    }

    public void displayOrderScreen(){
        System.out.println("""
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order - delete the order and go back to the home page
                """);

    }

    public void addSandwich(){
    }
    public void addDrink(){}
    public void addChips(){}
    public void checkout(){}

}
