package org.example.core.dao;

import org.example.commons.AddCustomerDetailsRequest;
import org.example.core.data.CustomerData;
import java.util.* ;

public interface ICustomerDataDAO {
    public Optional<CustomerData> getCustomerData(String CustomerId) ;
    public String addCustomerData(String newCustomerId , CustomerData newCustomer) ;
}
