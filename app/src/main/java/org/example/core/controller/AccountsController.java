package org.example.core.controller;

import java.util.List;
import java.util.Optional;

import org.example.commons.AccountBalanceRequest;
import org.example.commons.AccountBalanceResponse;
import org.example.commons.AddCustomerAccountRequest;
import org.example.commons.AddCustomerAccountResponse;
import org.example.commons.ListCustomerAccountRequest;
import org.example.commons.ListCustomerAccountResponse;
import org.example.commons.SetAccountBalanceRequest;
import org.example.commons.SetAccountBalanceResponse;
import org.example.core.data.Accounts;
import org.example.core.dto.TransactionReceipt;
import org.example.core.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {
    @Autowired
    private AccountsService accountService ;
    
    @PostMapping(value = "/addAccount")
    public AddCustomerAccountResponse createCustomerAccount(@RequestBody AddCustomerAccountRequest request) {
       return AddCustomerAccountResponse.builder().
            accountNumber(accountService.createAccount(request.getCustomerId())).build() ;
    }


    @PostMapping(value = "/setAccountBalance")
    public SetAccountBalanceResponse setAccountBalanceResponse(@RequestBody SetAccountBalanceRequest request){

     TransactionReceipt receipt = accountService.setAccountBalance(request.getAccountNumber() , request.getAmount() , request.getTransactionType()) ;

     return SetAccountBalanceResponse.builder()
            .transactionAmount(request.getAmount())
            .status(receipt.getStatus())
            .transactionDateAndTime(receipt.getTransactionDateAndTime()).transactionId(receipt.getTransactionId()).
            build() ;
   }

   @PostMapping(value = "/getAccountBalance")
   public AccountBalanceResponse accountBalance(@RequestBody AccountBalanceRequest request) {
        return AccountBalanceResponse.builder().balance(accountService.getBalance(request.getAccountNumber())).build() ;
    }

    
    @PostMapping(value = "/listCustomerAccount")
    public ListCustomerAccountResponse listCustomerAccounts(@RequestBody ListCustomerAccountRequest request) {
        Optional<List<Accounts>> accountList = accountService.listAccounts(request.getCustomerId()) ;
        return ListCustomerAccountResponse.builder().
            customerAccounts(accountList)
            .build() ;
    }

}
