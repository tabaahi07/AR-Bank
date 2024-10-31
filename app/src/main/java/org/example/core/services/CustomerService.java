package org.example.core.services;

import org.example.commons.AddCustomerDetailsRequest;
import org.example.core.dao.ICustomerDataDAO;
import org.example.core.data.CustomerData;
import org.example.core.db.inmem.CustomerDataDAO;

import lombok.Builder;

import java.util.* ;

@Builder
public class CustomerService {
    private ICustomerDataDAO customerDAO ;

    public String addCustomer(AddCustomerDetailsRequest request){
        return customerDAO.addCustomerData(request) ;
    } 
}
