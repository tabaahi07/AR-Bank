package org.example.cmd.screens;

import org.example.cmd.IBankScreen;

import java.util.Scanner;

import lombok.Builder;

@Builder
public class CreateAccount implements IBankScreen {
    @Override
    public void show(Scanner scanner) {
        System.out.println("Create Account");
    }

    @Override
    public IBankScreen next() {
        return null;
    }
}
