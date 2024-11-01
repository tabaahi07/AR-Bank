package org.example.commons;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class CustomerLoginRequest {
    private String userId;
    private String passwd;
} 
