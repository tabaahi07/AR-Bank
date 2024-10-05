package main.java.org.example.cmd;

import java.util.Scanner;

public class UIUserInput {
    // Singleton instance
    private static UIUserInput instance;
    
    // Encapsulated Scanner instance
    private Scanner scanner;

    // Private constructor to prevent external instantiation
    private UIUserInput() {
        this.scanner = new Scanner(System.in);
    }

    // Public static method to get the singleton instance
    public static UIUserInput getInstance() {
        if (instance == null) {
            instance = new UIUserInput();
        }
        return instance;
    }

    // Method to read an integer input
    public int nextInt() {
        return scanner.nextInt();
    }

    // Method to read a string input
    public String nextLine() {
        return scanner.nextLine();
    }

    // Additional methods for other input types if needed
    public double nextDouble() {
        return scanner.nextDouble();
    }

    // Ensure that the scanner is closed when the application is done using it
    public void close() {
        scanner.close();
    }
}
