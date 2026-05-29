package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private int sandwichInch;
    private Order currentOrder;
    private String name;
    public static Scanner input = new Scanner(System.in);
    // Reads and validates an integer value entered by the user.
    public int getIntInput() {
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
        }

        int number = input.nextInt();
        input.nextLine();
        return number;
    }
    // Displays the home screen menu and handles the user's selection.
    public void displayHomeScreen() {
        System.out.println("""
                1) New Order
                0) Exit - exit the application
                """);

        System.out.print("Choose an option: ");
        int choice = getIntInput();

        if (choice == 1) {
            System.out.print("Can I have your name please: ");
            name = input.nextLine();

            currentOrder = new Order(name);

            System.out.println("Welcome to CHEESY BURG, " + name + "!");
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
    // Shows the current order options and processes the user's selection.
    public void displayOrderScreen() {
        System.out.println("""
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order
                """);

        System.out.print("Choose an option: ");
        int choice = getIntInput();

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
    // Prompts the user to build a sandwich and adds it to the current order.
    public void addSandwich() {

        System.out.println("""
            Select sandwich option:
            1) Build Your Own Sandwich
            2) BLT
            3) Philly Cheese Steak
            0) Cancel
            """);

        System.out.print("Choose an option: ");
        int choice = getIntInput();

        if (choice == 1) {
            String breadType = getBreadType();
            sandwichInch = getSandwichSize();

            Sandwich sandwich = new Sandwich(sandwichInch, breadType, false);

            addMeat(sandwich);
            addCheese(sandwich);
            addRegularToppings(sandwich);
            addSauces(sandwich);
            askToasted(sandwich);
            addSides(sandwich);

            currentOrder.addSandwich(sandwich);

            System.out.println("Custom sandwich added!");
            displayOrderScreen();
        }
        else if (choice == 2) {
            Sandwich blt = new BLT();

            System.out.println("Do you want to customize your BLT?");
            System.out.println("""
                1) Yes
                2) No
                """);

            int customize = getIntInput();

            if (customize == 1) {
                sandwichInch = blt.getSize();
                addMeat(blt);
                addCheese(blt);
                addRegularToppings(blt);
                addSauces(blt);
                addSides(blt);
            }

            currentOrder.addSandwich(blt);

            System.out.println("BLT added!");
            displayOrderScreen();
        }
        else if (choice == 3) {
            Sandwich philly = new PhillyCheeseSteak();

            System.out.println("Do you want to customize your Philly Cheese Steak?");
            System.out.println("""
                1) Yes
                2) No
                """);

            int customize = getIntInput();

            if (customize == 1) {
                sandwichInch = philly.getSize();
                addMeat(philly);
                addCheese(philly);
                addRegularToppings(philly);
                addSauces(philly);
                addSides(philly);
            }

            currentOrder.addSandwich(philly);

            System.out.println("Philly Cheese Steak added!");
            displayOrderScreen();
        }
        else if (choice == 0) {
            displayOrderScreen();
        }
        else {
            System.out.println("Invalid choice.");
            addSandwich();
        }
    }
    // Prompts the user to select a drink and adds it to the current order.
    public void addDrink() {
        while (true) {

            System.out.println("""
                Select drink size:
                1) Small
                2) Medium
                3) Large
                0) Cancel
                """);

            System.out.print("Choose an option: ");
            int choice = getIntInput();

            String size = "";
            double price = 0;

            if (choice == 1) {
                size = "Small";
                price = 2.00;
            }
            else if (choice == 2) {
                size = "Medium";
                price = 2.50;
            }
            else if (choice == 3) {
                size = "Large";
                price = 3.00;
            }
            else if (choice == 0) {
                displayOrderScreen();
                return;
            }
            else if (!invalidOption()) {
                displayOrderScreen();
                return;
            }
            else {
                continue;
            }

            Drink drink = new Drink(size, price);

            currentOrder.addDrink(drink);

            System.out.println(size + " drink added!");

            displayOrderScreen();
            return;
        }
    }
    // Prompts the user to select chips and adds them to the current order.
    public void addChips() {
        while (true) {

            System.out.println("""
                Add chips?
                1) Yes
                2) No
                """);

            System.out.print("Choose an option: ");
            int choice = getIntInput();

            if (choice == 1) {

                Chips chips = new Chips(1.50);

                currentOrder.addChip(chips);

                System.out.println("Chips added!");

                displayOrderScreen();
                return;
            }

            else if (choice == 2) {
                displayOrderScreen();
                return;
            }

            else if (!invalidOption()) {
                displayOrderScreen();
                return;
            }
        }
    }
    // Processes the current order and generates a receipt for the customer.
    public void checkout() {

        if (currentOrder == null) {
            System.out.println("There is no current order!");
            displayHomeScreen();
            return;
        }
        if(currentOrder.getSandwiches().isEmpty()
                && currentOrder.getDrinks().isEmpty()
                && currentOrder.getChips().isEmpty()) {

            System.out.println("You must order at least a sandwich, drink, or chips.");
            displayOrderScreen();
            return;
        }

        System.out.println("""
            ===== CHEESY BURG RECEIPT =====
            """);

        System.out.println("Customer: " + name);
        System.out.println();

        for (Sandwich sandwich : currentOrder.getSandwiches()) {

            System.out.println(sandwich.getSize() + "\" " + sandwich.getBread() + " Sandwich");

            if (sandwich.isToasted()) {
                System.out.println("Toasted");
            }

            for (Topping topping : sandwich.getToppings()) {
                System.out.println("- " + topping.getName());
            }

            System.out.printf("Price: $%.2f%n", sandwich.getPrice());
            System.out.println();
        }

        for (Drink drink : currentOrder.getDrinks()) {

            System.out.println(drink.getSize() + " Drink");
            System.out.printf("Price: $%.2f%n", drink.getPrice());
            System.out.println();
        }

        for (Chips chips : currentOrder.getChips()) {

            System.out.println("Chips");
            System.out.printf("Price: $%.2f%n", chips.getPrice());
            System.out.println();
        }

        System.out.printf("TOTAL: $%.2f%n", currentOrder.getTotalPrice());

        System.out.println("""
            
            1) Confirm
            2) Cancel
            """);

        System.out.print("Choose an option: ");
        int choice = getIntInput();

        if (choice == 1) {
            boolean saved = ReceiptFileManager.saveReceipt(currentOrder);

            if (saved) {
                System.out.println("Receipt saved successfully!");
            } else {
                System.out.println("Receipt was not saved.");
            }

            currentOrder = null;
            displayHomeScreen();
        }
        else if (choice == 2) {
            System.out.println("Order cancelled.");
            currentOrder = null;
            displayHomeScreen();
        }
        else {
            System.out.println("Invalid choice.");
            checkout();
        }
    }
    // Handles invalid user input.
    public boolean invalidOption() {
        System.out.println("Invalid choice " + name + ". Do you want to try again?");
        System.out.println("""
                1) Yes
                2) No
                """);

        System.out.print("Choose 1 or 2: ");
        int choice = getIntInput();

        return choice == 1;
    }
    // Calculates and returns the meat cost according to the sandwich size.
    public double getMeatPriceBySize() {
        if (sandwichInch == 4) {
            return 1.00;
        }
        else if (sandwichInch == 8) {
            return 2.00;
        }
        else {
            return 3.00;
        }
    }
    // Calculates and returns the cost of extra meat according to the sandwich size.
    public double getExtraMeatPriceBySize() {
        if (sandwichInch == 4) {
            return 0.50;
        }
        else if (sandwichInch == 8) {
            return 1.00;
        }
        else {
            return 1.50;
        }
    }
    // Calculates and returns the cheese cost according to the sandwich size.
    public double getCheesePriceBySize() {
        if (sandwichInch == 4) {
            return 0.75;
        }
        else if (sandwichInch == 8) {
            return 1.50;
        }
        else {
            return 2.25 ;
        }
    }
    // Calculates and returns the cost of extra cheese according to the sandwich size.
    public double getExtraCheesePriceBySize() {
        if (sandwichInch == 4) {
            return 0.30;
        }
        else if (sandwichInch == 8) {
            return 0.60;
        }
        else {
            return 0.90;
        }
    }
    // Prompts the user to select a bread type and returns the chosen option.
    public String getBreadType() {
        while (true) {
            System.out.println("""
                Select your bread:
                1) White
                2) Wheat
                3) Rye
                4) Wrap
                """);

            System.out.print("Choose an option: ");
            int choice = getIntInput();

            if (choice == 1) {
                return "White";
            }
            else if (choice == 2) {
                return "Wheat";
            }
            else if (choice == 3) {
                return "Rye";
            }
            else if (choice == 4) {
                return "Wrap";
            }
            else if (!invalidOption()) {
                displayOrderScreen();
                return "";
            }
        }
    }
    // Retrieves the sandwich size selected by the user.
    public int getSandwichSize() {
        while (true) {
            System.out.println("""
                Sandwich size:
                1) 4"
                2) 8"
                3) 12"
                """);

            System.out.print("Choose an option: ");
            int choice = getIntInput();

            if (choice == 1) {
                return 4;
            }
            else if (choice == 2) {
                return 8;
            }
            else if (choice == 3) {
                return 12;
            }
            else if (!invalidOption()) {
                displayOrderScreen();
                return 0;
            }
        }
    }
    // Adds selected meat options to the sandwich and updates its price.
    public void addMeat(Sandwich sandwich) {
        String meatName="No meat";
        double meatPrice = 0;
        double extraMeatPrice = 0;

        while (true) {
            System.out.println("""
                Do you want meat?
                1) Yes
                2) No
                """);

            System.out.print("Choose an option: ");
            int choice = getIntInput();

            if (choice == 1) {
                meatPrice = getMeatPriceBySize();

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
                    int meatChoice = getIntInput();

                    if (meatChoice == 1) {
                        meatName = "Steak";
                    }
                    else if (meatChoice == 2) {
                        meatName = "Ham";
                    }
                    else if (meatChoice == 3) {
                        meatName = "Salami";
                    }
                    else if (meatChoice == 4) {
                        meatName = "Roast Beef";
                    }
                    else if (meatChoice == 5) {
                        meatName = "Chicken";
                    }
                    else if (meatChoice == 6) {
                        meatName = "Bacon";
                    }
                    else if (!invalidOption()) {
                        displayOrderScreen();
                        return;
                    }
                    else {
                        continue;
                    }

                    Meat meat = new Meat(meatName, meatPrice);
                    sandwich.addTopping(meat);

                    break;
                }

                while (true) {
                    System.out.println("""
                        Do you want extra meat?
                        1) Yes
                        2) No
                        """);

                    System.out.print("Choose an option: ");
                    int extraChoice = getIntInput();

                    if (extraChoice == 1) {
                        extraMeatPrice = getExtraMeatPriceBySize();

                        Meat extraMeat = new Meat(
                                "Extra " + meatName,
                                extraMeatPrice
                        );

                        sandwich.addTopping(extraMeat);

                        break;
                    }
                    else if (extraChoice == 2) {
                        break;
                    }
                    else if (!invalidOption()) {
                        displayOrderScreen();
                        return;
                    }
                }

                break;
            }
            else if (choice == 2) {
                break;
            }
            else if (!invalidOption()) {
                displayOrderScreen();
                return;
            }
        }
    }
    // Adds cheese toppings to the sandwich.
    public void addCheese(Sandwich sandwich) {
        String cheeseName = "";
        double cheesePrice = 0;
        double extraCheesePrice = 0;

        while (true) {
            System.out.println("""
                Do you want cheese?
                1) Yes
                2) No
                """);

            System.out.print("Choose an option: ");
            int choice = getIntInput();

            if (choice == 1) {
                cheesePrice = getCheesePriceBySize();

                while (true) {
                    System.out.println("""
                        Select cheese:
                        1) American
                        2) Provolone
                        3) Cheddar
                        4) Swiss
                        """);

                    System.out.print("Choose an option: ");
                    int cheeseChoice = getIntInput();

                    if (cheeseChoice == 1) {
                        cheeseName = "American";
                    }
                    else if (cheeseChoice == 2) {
                        cheeseName = "Provolone";
                    }
                    else if (cheeseChoice == 3) {
                        cheeseName = "Cheddar";
                    }
                    else if (cheeseChoice == 4) {
                        cheeseName = "Swiss";
                    }
                    else if (!invalidOption()) {
                        displayOrderScreen();
                        return;
                    }
                    else {
                        continue;
                    }

                    Cheese cheese = new Cheese(cheeseName, cheesePrice);
                    sandwich.addTopping(cheese);

                    break;
                }

                while (true) {
                    System.out.println("""
                        Do you want extra cheese?
                        1) Yes
                        2) No
                        """);

                    System.out.print("Choose an option: ");
                    int extraChoice = getIntInput();
                    if (extraChoice == 1) {
                        extraCheesePrice = getExtraCheesePriceBySize();

                        Cheese extraCheese = new Cheese(
                                "Extra " + cheeseName,
                                extraCheesePrice
                        );

                        sandwich.addTopping(extraCheese);
                        break;
                    }
                    else if (extraChoice == 2) {
                        break;
                    }
                    else if (!invalidOption()) {
                        displayOrderScreen();
                        return;
                    }
                }

                break;
            }
            else if (choice == 2) {
                break;
            }
            else if (!invalidOption()) {
                displayOrderScreen();
                return;
            }
        }
    }
    // Adds selected regular toppings to the sandwich.
    public void addRegularToppings(Sandwich sandwich){

        while (true) {
            System.out.println("""
                Do you want regular toppings?
                1) Yes
                2) No
                """);

            System.out.print("Choose an option: ");
            int choice = getIntInput();

            if (choice == 1) {

                while (true) {

                    System.out.println("""
                        Select topping:
                        1) Lettuce
                        2) Peppers
                        3) Onions
                        4) Tomatoes
                        5) Jalapenos
                        6) Cucumbers
                        7) Pickles
                        8) Guacamole
                        9) Mushrooms
                        0) Done
                        """);

                    System.out.print("Choose an option: ");
                    int toppingChoice = getIntInput();
                    String toppingName="";

                    if (toppingChoice == 1) {
                        toppingName = "Lettuce";
                    }
                    else if (toppingChoice == 2) {
                        toppingName = "Peppers";
                    }
                    else if (toppingChoice == 3) {
                        toppingName = "Onions";
                    }
                    else if (toppingChoice == 4) {
                        toppingName = "Tomatoes";
                    }
                    else if (toppingChoice == 5) {
                        toppingName = "Jalapenos";
                    }
                    else if (toppingChoice == 6) {
                        toppingName = "Cucumbers";
                    }
                    else if (toppingChoice == 7) {
                        toppingName = "Pickles";
                    }
                    else if (toppingChoice == 8) {
                        toppingName = "Guacamole";
                    }
                    else if (toppingChoice == 9) {
                        toppingName = "Mushrooms";
                    }
                    else if (toppingChoice == 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                    RegularTopping topping = new RegularTopping(toppingName);
                    sandwich.addTopping(topping);
                }
                break;
            }
            else if(choice==2){
                break;
            }

            else if(!invalidOption()){
                displayOrderScreen();
                return;
            }
        }
    }
    // Adds selected regular sauces to the sandwich
    public void addSauces(Sandwich sandwich){

        while (true) {
            System.out.println("""
                Do you want sauces?
                1) Yes
                2) No
                """);

            System.out.print("Choose an option: ");
            int choice = getIntInput();

            if (choice == 1) {

                while (true) {

                    System.out.println("""
                        Select sauce:
                        1) Mayo
                        2) Mustard
                        3) Ketchup
                        4) Ranch
                        5) Thousand Islands
                        6) Vinaigrette
                        0) Done
                        """);

                    System.out.print("Choose an option: ");
                    int sauceChoice = getIntInput();
                    String sauceName = "";

                    if (sauceChoice == 1) {
                        sauceName = "Mayo";
                    }
                    else if (sauceChoice == 2) {
                        sauceName = "Mustard";
                    }
                    else if (sauceChoice == 3) {
                        sauceName = "Ketchup";
                    }
                    else if (sauceChoice == 4) {
                        sauceName = "Ranch";
                    }
                    else if (sauceChoice == 5) {
                        sauceName = "Thousand Islands";
                    }
                    else if (sauceChoice == 6) {
                        sauceName = "Vinaigrette";
                    }
                    else if (sauceChoice == 0) {
                        break;
                    }
                    else {
                        continue;
                    }

                    Sauce sauce = new Sauce(sauceName);

                    sandwich.addTopping(sauce);

                }

                break;
            }
            else if (choice == 2){
                break;
            }
            else if (!invalidOption()){
                displayOrderScreen();
                return;
            }
        }
    }
    // Prompts the user to choose if the sandwich should be toasted.
    public void askToasted(Sandwich sandwich){

        System.out.println("""
            Would you like the sandwich toasted?
            1) Yes
            2) No
            """);

        int choice = getIntInput();

        if(choice == 1){
            sandwich.setToasted(true);
        }
    }
    // Adds selected side options to the sandwich.
    public void addSides(Sandwich sandwich){

        while (true){

            System.out.println("""
                Add side?
                1) Au Jus
                2) Sauce
                3) None
                """);

            int choice = getIntInput();

            if(choice == 1){

                sandwich.addTopping(
                        new Side("Au Jus")
                );

                break;
            }

            else if(choice == 2){

                sandwich.addTopping(
                        new Side("Sauce")
                );

                break;
            }

            else if(choice == 3){
                break;
            }

            else if(!invalidOption()){
                displayOrderScreen();
                return;
            }
        }
    }
}