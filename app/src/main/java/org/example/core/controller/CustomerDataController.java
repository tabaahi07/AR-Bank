package org.example.core.controller;

import java.util.List;
import java.util.Optional;

import org.example.commons.AddCustomerDetailsRequest;
import org.example.commons.AddCustomerDetailsResponse;
import org.example.commons.ListCustomerAccountRequest;
import org.example.commons.ListCustomerAccountResponse;
import org.example.core.data.Accounts;
import org.example.core.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerDataController {
    @Autowired
    private CustomerService customerService ;

    @PostMapping(value = "/addCustomer")
    public AddCustomerDetailsResponse createCustomer(@RequestBody AddCustomerDetailsRequest request) {
        return AddCustomerDetailsResponse.builder()
            .customerId(customerService.addCustomer(request))
            .build() ;
    }
} 
