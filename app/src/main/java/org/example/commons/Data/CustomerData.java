package org.example.commons.Data;
import lombok.Builder ; 
import java.time.LocalDate;

@Builder
public class CustomerData {
    private String customerId ;
    private String passwordHash ; 
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


