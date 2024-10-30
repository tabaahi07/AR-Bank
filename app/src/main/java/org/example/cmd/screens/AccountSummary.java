package org.example.cmd.screens;

import org.example.cmd.Context;
import org.example.cmd.IBankScreen;
import org.example.commons.ListCustomerAccountRequest;
import org.example.commons.ListCustomerAccountResponse;

import lombok.Builder;

@Builder
public class AccountSummary implements IBankScreen {
    @Override
    public void show() {
        ListCustomerAccountResponse response = Context 
            .getInstance()
            .getBankApp()
            .listCustomerAccounts(
                ListCustomerAccountRequest
                    .builder()
                    .authToken(Context.getInstance().getAccessToken())
                    .build()
            ); 

        System.out.println("Account Summary");
        
    }

    @Override
    public IBankScreen next() {
        return null;
    }

}
