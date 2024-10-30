package org.example.core.db.inmem;
import java.util.*;
import java.time.*;
import org.example.core.dao.IAccountsDAO;
import org.example.core.data.Accounts;


import java.util.*;

public class AccountsDAO implements IAccountsDAO {
    private Map<String , List<Accounts>> accountsMap = new HashMap<>() ;
    private Map<String , Accounts> accountDetailMap = new HashMap<>() ;
    public String createAccount(String customerId){
        String newAccountNumber = UUID.randomUUID().toString();
        List<Accounts> currentAccountList = accountsMap.get(customerId) ;

        Accounts newAccount = Accounts.builder().customerId(customerId).accountNumber(newAccountNumber).balance(0).issuedDate(LocalDate.now()).build() ;

        accountDetailMap.put(newAccountNumber , newAccount) ;
        currentAccountList.add(newAccount) ;
        accountsMap.put(customerId , currentAccountList) ;
        return newAccountNumber ;
    }

    public Optional<List<Accounts>> getAccounts(String customerId){
        return Optional.ofNullable(accountsMap.get(customerId)) ;
    }

    public Optional<Accounts> depositAmount(String accountNumber , Integer amount){
        if(!accountDetailMap.containsKey(accountNumber)) return null ;
        Accounts userAccount = accountDetailMap.get(accountNumber) ;
        userAccount.setBalance(userAccount.getBalance() + amount) ;
        return Optional.of(userAccount) ;
    }

    public Optional<Accounts> withdrawAmount(String accountNumber , Integer amount){
        if(!accountDetailMap.containsKey(accountNumber)) return null ;
        Accounts userAccount = accountDetailMap.get(accountNumber) ;
        userAccount.setBalance(userAccount.getBalance() - amount) ;
        return Optional.of(userAccount) ;
    }

    public Optional<Accounts> getBalance(String accountNumber){
        return Optional.ofNullable(accountDetailMap.get(accountNumber));
    }
}
