package org.example.core.services;
import org.example.core.dao.IAuthDAO;
import org.example.core.data.UserAuth;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Builder;

@Builder
@Service
public class AuthService {

    private IAuthDAO authDAO;

    /**
     * 1. Check if user exists
     * 2. Check if password is correct
     * 3. Generate and return access token
     * @param userId
     * @param passwd
     * @return
     */
    public String login(String userId, String passwd) {
        Optional<UserAuth> userAuth = authDAO.getUserAuth(userId);
        if (userAuth.isEmpty()) return null;
        if (!userAuth.get().getHashedPasswd().equals(passwd)) return null;
        if (userAuth.get().getTokenExpiry().isAfter(LocalDateTime.now())) return userAuth.get().getAccessToken();
        return "Hi";
    }
}
