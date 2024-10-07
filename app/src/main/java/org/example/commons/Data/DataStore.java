package org.example.commons.Data;
import java.util.* ;
import lombok.Setter ;

@Setter
public class DataStore {
    // customerId - Customer info
    public Map<String , CustomerData> CustomerDataMap ;
    // CustomerId - Customer accounts list
    public Map<String , List<AccountData>> CustomerAccountsMap ;
    // AccountId - Account Details
    public Map<String , AccountData> AccountDataMap ;
    // CustomerId - LoginToken
    public Map<String , List<LoginSession>> LoginSessionMap ;
    private static DataStore Instance ;
    private void DataStore(){
        CustomerDataMap = new HashMap<>() ;
    }
    public static DataStore getInstance(){
        if(Instance == null) Instance = new DataStore() ;
        return Instance ;
    } 
}
