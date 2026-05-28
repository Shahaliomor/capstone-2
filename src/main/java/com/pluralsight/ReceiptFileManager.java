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

            writer.close();

            return true;

        }

        catch (Exception e) {

            System.out.println("Error saving receipt.");

            return false;
        }
    }
}