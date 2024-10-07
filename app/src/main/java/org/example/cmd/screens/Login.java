package org.example.cmd.screens;

import org.example.cmd.Context;
import org.example.cmd.IBankScreen;
import org.example.cmd.UIUserInput;
import org.example.commons.CustomerLoginRequest;
import org.example.commons.CustomerLoginResponse;
import org.example.commons.Enums.LoginStatus;

import lombok.Builder;

@Builder
public class Login implements IBankScreen {
    private String username;
    private String password;

    @Override
    public void show() {
        System.out.println("Login");
        System.out.print("username: ");
        this.username = UIUserInput.getInstance().nextLine();
        System.out.print("password: ");
        this.password = UIUserInput.getInstance().nextLine();
    }

    @Override
    public IBankScreen next() {
        CustomerLoginResponse response = Context.getInstance().getBankApp().customerLogin(CustomerLoginRequest.builder().userId(this.username).passwd(this.password).build());
        Context.getInstance().setAccessToken(response.getAccessToken());
        if (LoginStatus.SUCCESS.equals(response.getStatus())) {
            return AccountSummary.builder().build();
        } else {
            System.out.println("Login failed. Please try again.");
            return this;
        }
    }
}
