package main.java.org.example.cmd;

import java.util.Scanner;

public interface IBankScreen {
    void show(Scanner scanner);
    IBankScreen next();
}
