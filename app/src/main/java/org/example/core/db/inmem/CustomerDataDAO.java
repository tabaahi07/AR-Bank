package org.example.core.db.inmem;
import java.util.* ;
import org.example.core.dao.ICustomerDataDAO;
import org.example.core.data.CustomerData;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDataDAO implements ICustomerDataDAO {
    private Map<String , CustomerData> CustomerDataMap = new HashMap<>() ;

    @Override
    public Optional<CustomerData> getCustomerData(String CustomerId){
        return Optional.ofNullable(CustomerDataMap.get(CustomerId));
    }
    
    @Override
    public String addCustomerData(String newCustomerId , CustomerData newCustomer){
        CustomerDataMap.put(newCustomerId , newCustomer) ;
        return newCustomerId ;
    }
}
