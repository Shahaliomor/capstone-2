package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private int sandwichInch;
    private Order currentOrder;
    private String name;
    public static Scanner input = new Scanner(System.in);
    // Display the home screen menu
    public void displayHomeScreen(){
        System.out.println("""
                1) New Order
                0) Exit - exit the application
                """);
        System.out.print("Choose an option: ");
        int choice = input.nextInt();
        input.nextLine();
        if(choice == 1){
            System.out.print("Can I have your name please: ");
            name = input.nextLine();

            currentOrder = new Order(name);

            System.out.println("Welcome to CHEESY BURG, " + name + "!");
            System.out.println("How can I help you?");
            displayOrderScreen();
        }
        else if(choice == 0) {
            System.out.println("Thanks for choosing CHEESY BURG, Goodbye!");
            return;
        }
        else{
            System.out.println("Invalid choice "+ name+", try again.");
            displayHomeScreen();
        }


    }
    // Show order options
    public void displayOrderScreen(){
        System.out.println("""
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order - delete the order and go back to the home page
                  """);
        System.out.print("Choose an option: ");
        int choice = input.nextInt();

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
            System.out.println("Invalid choice "+ name+", try again.");
            displayOrderScreen();
        }

    }
    // Add sandwich to current order
    public void addSandwich(){
        while(true){
            System.out.print("""
                        How many Inch Sandwich you want to add: 
                            1) 4"
                            2) 8"
                            3) 12"
                        """);
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            if (choice == 1) {
                sandwichInch = 4;
            }
            else if (choice == 2) {
                sandwichInch = 8;
            }
            else if (choice == 3) {
                sandwichInch = 12;
            }
            else {
                System.out.println("Invalid choice "+ name+". DO you want to try again?");
                System.out.println("""
                    1) Yes
                    2) No
                    Choose 1 or 2: 
                    """);
                int  choice2 = input.nextInt();
                input.nextLine();
                if (choice2 == 1) {
                    continue;
                }
                else if (choice2 == 2) {
                    break;
                }
                else {
                    System.out.println("Invalid choice "+ name);
                    return;
                }
            }
        }


    }
    // Add drink to current order
    public void addDrink(){}
    // Add Chips to current order
    public void addChips(){}
    // Display order details and complete order
    public void checkout(){}

}
