package org.example.commons;
import java.time.LocalDate;
import lombok.Getter; 

@Getter
public class AddCustomerDetailsRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    private String PAN;
    private String address;
    private String aadharNumber;    
}
