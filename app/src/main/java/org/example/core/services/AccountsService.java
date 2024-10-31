package org.example.core.services;
import org.example.core.dao.IAccountsDAO;
import org.example.core.data.Accounts;
import java.time.* ;

import lombok.Builder;

import java.util.* ;

@Builder
public class AccountsService {
    private IAccountsDAO accountDAO ;

    public String createAccount(String customerId){
        String newAccountNumber = UUID.randomUUID().toString();
        Accounts newAccount = Accounts.builder().customerId(customerId).accountNumber(newAccountNumber).balance(0).issuedDate(LocalDate.now()).build() ;
        return accountDAO.createAccount(newAccountNumber , newAccount , customerId) ;
    }

    public Optional<List<Accounts>> geAccounts(String customerId){
        Optional<List<Accounts>> accountList = accountDAO.getAccounts(customerId) ;
        if(accountList.isEmpty()) return null ;
        return accountList ;
    }

    public Optional<Accounts> depositAmount(String accountNumber , Integer amount){
        return accountDAO.depositAmount(accountNumber, amount) ;
    }

    public Optional<Accounts> withdrawAmount(String accountNumber , Integer amount){
        return accountDAO.withdrawAmount(accountNumber, amount) ;
    }

    public Integer getBalance(String accountNumber){
        Optional<Accounts> userAccount = accountDAO.getBalance(accountNumber) ;
        if(userAccount.isEmpty()) return 0 ;
        return userAccount.get().getBalance() ;
    }
}
