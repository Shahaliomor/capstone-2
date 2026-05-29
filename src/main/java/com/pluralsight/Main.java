package com.pluralsight;
//Main Class
public class Main {
    //Main function
    public static void main(String[] args) {
        //Create a UserInterface object
        UserInterface ui = new UserInterface();
       //keep application running until user exits.
        while (true) {
            ui.displayHomeScreen();
            break;
        }

    }
}
