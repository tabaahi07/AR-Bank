package org.example.cmd;

import org.example.IBankApp;

import lombok.Getter;
import lombok.Setter;

public class Context {
    // Private static instance of the same class that will hold the single instance
    private static Context instance;

    @Getter
    @Setter
    private IBankApp bankApp;

    @Getter
    @Setter
    private String accessToken;

    // Private constructor to restrict instantiation from outside the class
    private Context() {
        // Private to prevent instantiation
    }

    // Public static method that provides the single instance of the class
    public static Context getInstance() {
        if (instance == null) {
            // Lazily initialized, instance created when needed
            instance = new Context();
        }
        return instance;
    }

    // Other methods of Context class can go here
}
