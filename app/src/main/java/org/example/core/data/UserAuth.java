package org.example.core.data;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class UserAuth {
    private String userId;
    private String hashedPasswd;
    private String accessToken;
    private LocalDateTime tokenExpiry;
}


