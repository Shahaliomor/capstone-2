package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private int sandwichInch;
    private String breadType;
    private Order currentOrder;
    private String name;
    private double price;

    public static Scanner input = new Scanner(System.in);

    public void displayHomeScreen() {
        System.out.println("""
                1) New Order
                0) Exit - exit the application
                """);

        System.out.print("Choose an option: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.print("Can I have your name please: ");
            name = input.nextLine();

            currentOrder = new Order(name);

            System.out.println("Welcome to CHEESY BURG, " + name + "!");
            System.out.println("How can I help you?");
            displayOrderScreen();
        }
        else if (choice == 0) {
            System.out.println("Thanks for choosing CHEESY BURG, Goodbye!");
        }
        else {
            System.out.println("Invalid choice, try again.");
            displayHomeScreen();
        }
    }

    public void displayOrderScreen() {
        System.out.println("""
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order - delete the order and go back to the home page
                """);

        System.out.print("Choose an option: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            addSandwich();
        }
        else if (choice == 2) {
            addDrink();
        }
        else if (choice == 3) {
            addChips();
        }
        else if (choice == 4) {
            checkout();
        }
        else if (choice == 0) {
            currentOrder = null;
            displayHomeScreen();
        }
        else {
            System.out.println("Invalid choice " + name + ", try again.");
            displayOrderScreen();
        }
    }

    public void addSandwich() {
        while (true) {
            System.out.println("""
                    Select your bread:
                    1) White
                    2) Wheat
                    3) Rye
                    4) Wrap
                    """);

            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                breadType = "White";
                break;
            }
            else if (choice == 2) {
                breadType = "Wheat";
                break;
            }
            else if (choice == 3) {
                breadType = "Rye";
                break;
            }
            else if (choice == 4) {
                breadType = "Wrap";
                break;
            }
            else {
                if (invalidOption()) {
                    continue;
                }
                else {
                    displayOrderScreen();
                    return;
                }
            }
        }
        while (true) {
            System.out.println("""
                    Sandwich size:
                    1) 4"
                    2) 8"
                    3) 12"
                    """);

            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                sandwichInch = 4;
                price=5.5;
                break;
            }
            else if (choice == 2) {
                sandwichInch = 8;
                price=7;
                break;
            }
            else if (choice == 3) {
                sandwichInch = 12;
                price=8.5;
                break;
            }
            else {
                if (invalidOption()) {
                    continue;
                }
                else {
                    displayOrderScreen();
                    return;
                }
            }
        }

        System.out.println("Sandwich selected: " + sandwichInch + "\" " + breadType+"price: "+price);
        displayOrderScreen();
    }

    public void addDrink() {
    }

    public void addChips() {
    }

    public void checkout() {
    }

    public boolean invalidOption() {
        System.out.println("Invalid choice " + name + ". Do you want to try again?");
        System.out.println("""
                1) Yes
                2) No
                """);

        System.out.print("Choose 1 or 2: ");
        int choice = input.nextInt();
        input.nextLine();

        return choice == 1;
    }
}