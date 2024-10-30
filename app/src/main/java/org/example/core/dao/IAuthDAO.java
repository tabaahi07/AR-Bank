package org.example.core.dao;

import org.example.core.data.UserAuth;
import java.util.Optional;

public interface IAuthDAO {
    public Optional<UserAuth> getUserAuth(String userId);
}

