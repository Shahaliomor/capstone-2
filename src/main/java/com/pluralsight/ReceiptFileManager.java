package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static boolean saveReceipt(Order order) {

        try {

            File folder =
                    new File("src/main/resources/Receipt");
            // Create the Receipt folder automatically if it does not exist
            if (!folder.exists()) {
                folder.mkdir();
            }

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

            String fileName = LocalDateTime.now().format(formatter) + ".txt";

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/resources/Receipt/" + fileName));

            writer.write("CHEESY BURG RECEIPT");
            writer.newLine();

            writer.write("Customer: " + order.getName());

            writer.newLine();
            writer.newLine();

            writer.write("Order Details:");
            writer.newLine();
            for (Sandwich sandwich : order.getSandwiches()) {

                writer.write(
                        sandwich.getSize()
                                + "\" "
                                + sandwich.getBread()
                                + " Sandwich"
                );

                writer.newLine();

                if (sandwich.isToasted()) {
                    writer.write("Toasted");
                    writer.newLine();
                }

                for (Topping topping : sandwich.getToppings()) {

                    writer.write(
                            "- "
                                    + topping.getName()
                    );

                    writer.newLine();
                }

                writer.write(
                        String.format(
                                "Price: $%.2f",
                                sandwich.getPrice()
                        )
                );

                writer.newLine();
                writer.newLine();
            }

            for (Drink drink : order.getDrinks()) {

                writer.write(
                        drink.getSize()
                                + " Drink"
                );

                writer.newLine();

                writer.write(
                        String.format(
                                "Price: $%.2f",
                                drink.getPrice()
                        )
                );

                writer.newLine();
                writer.newLine();
            }
            for (Chips chips : order.getChips()) {

                writer.write("Chips");

                writer.newLine();

                writer.write(
                        String.format(
                                "Price: $%.2f",
                                chips.getPrice()
                        )
                );

                writer.newLine();
                writer.newLine();
            }

            double totalPrice = 0;

            for (Sandwich sandwich : order.getSandwiches()) {
                totalPrice += sandwich.getPrice();
            }

            for (Drink drink : order.getDrinks()) {
                totalPrice += drink.getPrice();
            }

            for (Chips chips : order.getChips()) {
                totalPrice += chips.getPrice();
            }

            writer.write(
                    String.format(
                            "TOTAL: $%.2f",
                            totalPrice
                    )
            );
            writer.close();

            return true;

        }

        catch (Exception e) {

            System.out.println("Error saving receipt.");

            return false;
        }
    }
}