package org.example.commons.Data;
import java.time.* ;
import lombok.*;

@Builder
@Getter
public class LoginSession {
    private String customerId ;
    private String loginToken ;
    private LocalDateTime loginDateAndTime ;
}
