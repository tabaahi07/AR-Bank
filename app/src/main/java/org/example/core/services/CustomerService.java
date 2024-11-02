package org.example.core.services;
import org.example.commons.AddCustomerDetailsRequest;
import org.example.core.dao.ICustomerDataDAO;
import org.example.core.data.CustomerData;
import org.example.core.data.UserAuth;
import org.example.core.db.inmem.AuthDAO;
import org.example.core.db.inmem.CustomerDataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.* ;

@Builder
@Service
public class CustomerService {
    @Autowired
    private CustomerDataDAO customerDAO ;
    @Autowired
    private AuthDAO authDAO ;
    public String addCustomer(AddCustomerDetailsRequest request){
        String newCustomerId = UUID.randomUUID().toString();
        String accessToken = UUID.randomUUID().toString();
        CustomerData newCustomer = CustomerData.builder().
            firstName(request.getFirstName()).
            lastName(request.getLastName()).
            aadharNumber(request.getAadharNumber()).
            PAN(request.getPAN()).
            address(request.getAddress()).
            dateOfBirth(request.getDateOfBirth()).
            email(request.getEmail()).
            password(request.getPassword()).
            build() ;

        
        authDAO.setUserAuth(
                UserAuth.builder().
                hashedPasswd(request.getPassword()).
                userId(newCustomerId).
                accessToken(accessToken).
                tokenExpiry(LocalDateTime.now().plusMinutes(15)).build()
            );

        return customerDAO.addCustomerData(newCustomerId , newCustomer) ;
    } 
}
