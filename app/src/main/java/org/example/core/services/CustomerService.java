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
        String newCustomerId = UUID.randomUUID().toString();

        CustomerData newCustomer = CustomerData.builder().firstName(request.getFirstName()).lastName(request.getLastName()).aadharNumber(request.getAadharNumber()).PAN(request.getPAN()).address(request.getAddress()).dateOfBirth(request.getDateOfBirth()).email(request.getEmail()).password(request.getPassword()).build() ;

        return customerDAO.addCustomerData(newCustomerId , newCustomer) ;
    } 
}
