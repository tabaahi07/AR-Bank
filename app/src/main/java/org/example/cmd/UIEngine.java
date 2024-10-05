package main.java.org.example.cmd;

import main.java.org.example.IBankApp;
import main.java.org.example.cmd.screens.Intro;

import java.util.Scanner;

import lombok.Builder;

@Builder
public class UIEngine {
    private IBankApp bankApp;
    private IBankScreen currentScreen;
    private Scanner scanner;

    public void run() {
        while (currentScreen != null) {
            currentScreen.show(scanner);
            currentScreen = currentScreen.next();
        }
    }

}
