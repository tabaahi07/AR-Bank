package org.example.core.data;
import java.time.* ;
import lombok.*;

@Getter
@Builder
public class CustomerData {
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    private String PAN;
    private String address;
    private String aadharNumber;   
    private String password ; 
}
