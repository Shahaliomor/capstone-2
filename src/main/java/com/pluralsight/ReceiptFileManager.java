package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static void saveReceipt(Order order) {

        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

            String fileName = LocalDateTime.now().format(formatter) + ".txt";

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("receipts/" + fileName));

            writer.write("CHEESY BURG RECEIPT");
            writer.newLine();

            writer.write("Customer: "
                    + order.getName());

            writer.newLine();
            writer.newLine();

            writer.write("Order Details:");
            writer.newLine();

            writer.close();

        }
        catch (Exception e) {
            System.out.println(
                    "Error saving receipt."
            );
        }
    }
}