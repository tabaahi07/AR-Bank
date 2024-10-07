package org.example.cmd.screens;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.example.cmd.IBankScreen;
import org.example.cmd.UIUserInput;
import lombok.Builder;

@Builder
public class Intro implements IBankScreen {

    private int choice;

    @Override
    public void show() {
        System.out.println("Welcome to the bank! Please log into your existing account or create a new account.");
        System.out.println("1. Log in");
        System.out.println("2. Create a new account");
        System.out.println("3. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
        this.choice = UIUserInput.getInstance().nextInt();
    }

    @Override
    public IBankScreen next() {
        switch (this.choice) {
            case 1:
                return Login.builder().build();
            case 2:
                return CreateAccount.builder().build();
            case 3:
                return null; // Exits the application
            default:
                System.out.println("Invalid choice. Please try again.");
                return this; // Re-show the same screen if invalid input
        }
    }
}
