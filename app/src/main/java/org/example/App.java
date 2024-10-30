/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.example.core.BankApp;
import org.example.core.dao.IAuthDAO;
import org.example.core.db.mysql.AuthDAO;
import org.example.core.services.AuthService;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        IAuthDAO authDAO = new AuthDAO();
        BankApp bankApp = BankApp
            .builder().authService(
                AuthService
                    .builder()
                    .authDAO(authDAO)
                    .build()
            )
            .build();
    }
}
