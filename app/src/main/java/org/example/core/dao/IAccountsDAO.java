package org.example.core.dao;
import java.util.*;

import org.example.core.data.Accounts;







public interface IAccountsDAO {
    public String createAccount(String customerId) ;
    public Optional<List<Accounts>> getAccounts(String customerId) ;
    public Optional<Accounts> depositAmount(String accountNumber , Integer amount) ;
    public Optional<Accounts> withdrawAmount(String accountNumber , Integer amount) ;

    public Optional<Accounts> getBalance(String accountNumber) ;
}