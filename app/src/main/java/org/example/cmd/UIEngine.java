package org.example.cmd;

import org.example.IBankApp;
import org.example.cmd.screens.Intro;

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
