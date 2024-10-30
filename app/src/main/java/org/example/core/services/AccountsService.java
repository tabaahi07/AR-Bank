package org.example.core.services;
import org.example.core.dao.IAccountsDAO;
import org.example.core.data.Accounts;


import java.util.* ;


public class AccountsService {
    private IAccountsDAO accountService ;

    public String createAccount(String customerId){
        return accountService.createAccount(customerId) ;
    }

    public Optional<List<Accounts>> geAccounts(String customerId){
        Optional<List<Accounts>> accountList = accountService.getAccounts(customerId) ;
        if(accountList.isEmpty()) return null ;
        return accountList ;
    }

    public Optional<Accounts> depositAmount(String accountNumber , Integer amount){
        return accountService.depositAmount(accountNumber, amount) ;
    }

    public Optional<Accounts> withdrawAmount(String accountNumber , Integer amount){
        return accountService.withdrawAmount(accountNumber, amount) ;
    }

    public Integer getBalance(String accountNumber){
        Optional<Accounts> userAccount = accountService.getBalance(accountNumber) ;
        if(userAccount.isEmpty()) return 0 ;
        return userAccount.get().getBalance() ;
    }
}
