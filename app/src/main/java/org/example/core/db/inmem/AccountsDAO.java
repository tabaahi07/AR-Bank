package org.example.core.db.inmem;
import java.util.*;
import org.example.core.dao.IAccountsDAO;
import org.example.core.data.Accounts;
import org.springframework.stereotype.Repository;

import lombok.Builder;
import lombok.Getter;

@Getter
@Repository
@Builder
public class AccountsDAO implements IAccountsDAO {
    // CustomerId -- List of customer accounts
    private Map<String , List<Accounts>> accountsMap = new HashMap<>() ;
    // AccountNumber - accountInfo
    private Map<String , Accounts> accountDetailMap = new HashMap<>() ;
    
    public String createAccount(String newAccountNumber , Accounts newAccount , String customerId){
        List<Accounts> currentAccountList = accountsMap.get(customerId) ;
        if(currentAccountList == null) currentAccountList = new ArrayList<>() ;
        accountDetailMap.put(newAccountNumber , newAccount) ;
        currentAccountList.add(newAccount) ;
        accountsMap.put(customerId , currentAccountList) ;
        System.out.println("account added");
        return newAccountNumber ;
    }

    public Optional<List<Accounts>> listAccounts(String customerId){
        return Optional.ofNullable(accountsMap.get(customerId)) ;
    }

    public Optional<Accounts> setAccountBalance(String accountNumber , Integer amount){
        if(!accountDetailMap.containsKey(accountNumber)) return null ;

        Accounts userAccount = accountDetailMap.get(accountNumber) ;
        userAccount.setBalance(userAccount.getBalance() + amount) ;
        return Optional.of(userAccount) ;
    }

    
    public Optional<Accounts> getBalance(String accountNumber){
        return Optional.ofNullable(accountDetailMap.get(accountNumber));
    }
}
