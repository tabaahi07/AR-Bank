package org.example.core.dao;
import java.util.*;

import org.example.core.data.Accounts;

public interface IAccountsDAO {
    public String createAccount(String newAccountNumber , Accounts newAccount ,  String customerId) ;
    public Optional<List<Accounts>> getAccounts(String customerId) ;
    public Optional<Accounts> setAccountBalance(String accountNumber , Integer amount) ;

    public Optional<Accounts> getBalance(String accountNumber) ;
}
