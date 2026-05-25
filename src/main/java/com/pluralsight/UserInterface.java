package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private int sandwichInch;
    private String breadType;
    private Order currentOrder;
    private String name;
    private double price;
    private String meatName;
    private double meatPrice;
    private double extraMeatPrice;
    private String cheeseName;
    private double cheesePrice;
    private double extraCheesePrice;

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
        meatName = "No meat";
        meatPrice = 0;
        extraMeatPrice = 0;
        //Select bread
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
                if (!invalidOption()) {
                    displayOrderScreen();
                    return;
                }
            }
        }
        //Select size
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
                price = 5.50;
                break;
            }
            else if (choice == 2) {
                sandwichInch = 8;
                price = 7.00;
                break;
            }
            else if (choice == 3) {
                sandwichInch = 12;
                price = 8.50;
                break;
            }
            else {
                if (!invalidOption()) {
                    displayOrderScreen();
                    return;
                }
            }
        }
        //Select meat
        while (true) {
            System.out.println("""
                    Do you want meat?
                    1) Yes
                    2) No
                    """);

            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                if (sandwichInch == 4) {
                    meatPrice = 1.00;
                }
                else if (sandwichInch == 8) {
                    meatPrice = 2.00;
                }
                else {
                    meatPrice = 3.00;
                }

                while (true) {
                    System.out.println("""
                            Select meat:
                            1) Steak
                            2) Ham
                            3) Salami
                            4) Roast Beef
                            5) Chicken
                            6) Bacon
                            """);

                    System.out.print("Choose an option: ");
                    int meatChoice = input.nextInt();
                    input.nextLine();

                    if (meatChoice == 1) {
                        meatName = "Steak";
                        break;
                    }
                    else if (meatChoice == 2) {
                        meatName = "Ham";
                        break;
                    }
                    else if (meatChoice == 3) {
                        meatName = "Salami";
                        break;
                    }
                    else if (meatChoice == 4) {
                        meatName = "Roast Beef";
                        break;
                    }
                    else if (meatChoice == 5) {
                        meatName = "Chicken";
                        break;
                    }
                    else if (meatChoice == 6) {
                        meatName = "Bacon";
                        break;
                    }
                    else {
                        if (!invalidOption()) {
                            displayOrderScreen();
                            return;
                        }
                    }
                }
                //Select extra meat
                while (true) {
                    System.out.println("""
                            Do you want extra meat?
                            1) Yes
                            2) No
                            """);

                    System.out.print("Choose an option: ");
                    int extraChoice = input.nextInt();
                    input.nextLine();

                    if (extraChoice == 1) {
                        if (sandwichInch == 4) {
                            extraMeatPrice = 0.50;
                        }
                        else if (sandwichInch == 8) {
                            extraMeatPrice = 1.00;
                        }
                        else {
                            extraMeatPrice = 1.50;
                        }
                        break;
                    }
                    else if (extraChoice == 2) {
                        extraMeatPrice = 0;
                        break;
                    }
                    else {
                        if (!invalidOption()) {
                            displayOrderScreen();
                            return;
                        }
                    }
                }

                break;
            }
            else if (choice == 2) {
                meatName = "No meat";
                meatPrice = 0;
                extraMeatPrice = 0;
                break;
            }
            else {
                if (!invalidOption()) {
                    displayOrderScreen();
                    return;
                }
            }
        }
        while (true) {
            System.out.println("""
            Do you want cheese?
            1) Yes
            2) No
            """);

            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                if (sandwichInch == 4) {
                    cheesePrice = 0.75;
                }
                else if (sandwichInch == 8) {
                    cheesePrice = 1.50;
                }
                else {
                    cheesePrice = 2.25;
                }

                while (true) {
                    System.out.println("""
                    Select cheese:
                    1) American
                    2) Provolone
                    3) Cheddar
                    4) Swiss
                    """);

                    System.out.print("Choose an option: ");
                    int cheeseChoice = input.nextInt();
                    input.nextLine();

                    if (cheeseChoice == 1) {
                        cheeseName = "American";
                        break;
                    }
                    else if (cheeseChoice == 2) {
                        cheeseName = "Provolone";
                        break;
                    }
                    else if (cheeseChoice == 3) {
                        cheeseName = "Cheddar";
                        break;
                    }
                    else if (cheeseChoice == 4) {
                        cheeseName = "Swiss";
                        break;
                    }
                    else {
                        if (!invalidOption()) {
                            return;
                        }
                    }
                }

                while (true) {
                    System.out.println("""
                    Do you want extra cheese?
                    1) Yes
                    2) No
                    """);

                    System.out.print("Choose an option: ");
                    int extraChoice = input.nextInt();
                    input.nextLine();

                    if (extraChoice == 1) {

                        if (sandwichInch == 4) {
                            extraCheesePrice = 0.30;
                        }
                        else if (sandwichInch == 8) {
                            extraCheesePrice = 0.60;
                        }
                        else {
                            extraCheesePrice = 0.90;
                        }

                        break;
                    }
                    else if (extraChoice == 2) {
                        extraCheesePrice = 0;
                        break;
                    }
                    else {
                        if (!invalidOption()) {
                            return;
                        }
                    }
                }

                break;
            }

            else if (choice == 2) {
                cheeseName = "No Cheese";
                cheesePrice = 0;
                extraCheesePrice = 0;
                break;
            }

            else {
                if (!invalidOption()) {
                    return;
                }
            }
        }

        double totalPrice = price + meatPrice + extraMeatPrice;

        System.out.println("Sandwich selected: " + sandwichInch + "\" " + breadType);
        System.out.println("Meat: " + meatName);
        System.out.println("Total sandwich price: $" + totalPrice);

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