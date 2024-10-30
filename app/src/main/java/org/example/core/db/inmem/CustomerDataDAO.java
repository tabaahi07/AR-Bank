package org.example.core.db.inmem;
import java.util.* ;

import org.example.commons.AddCustomerDetailsRequest;
import org.example.core.dao.ICustomerDataDAO;
import org.example.core.data.CustomerData;
import java.util.* ;

public class CustomerDataDAO implements ICustomerDataDAO {
    private Map<String , CustomerData> CustomerDataMap = new HashMap<>() ;

    @Override
    public Optional<CustomerData> getCustomerData(String CustomerId){
        return Optional.ofNullable(CustomerDataMap.get(CustomerId));
    }
    
    @Override
    public String addCustomerData(AddCustomerDetailsRequest request){
        String uniqueID = UUID.randomUUID().toString();
        CustomerDataMap.put(uniqueID , CustomerData.builder().firstName(request.getFirstName()).lastName(request.getLastName()).aadharNumber(request.getAadharNumber()).PAN(request.getPAN()).address(request.getAddress()).dateOfBirth(request.getDateOfBirth()).email(request.getEmail()).password(request.getPassword()).build()) ;

        return uniqueID ;
    }
}
