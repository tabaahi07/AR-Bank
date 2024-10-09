package org.example.core.data;
import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class UserAuth {
    private String userId;
    private String hashedPasswd;
    private String accessToken;
    private LocalDateTime tokenExpiry;
}
