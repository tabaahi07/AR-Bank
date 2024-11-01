package org.example.core.db.inmem;
import org.example.core.dao.IAuthDAO;
import java.util.*;
import org.example.core.data.UserAuth;
import org.springframework.stereotype.Repository;

@Repository
public class AuthDAO implements IAuthDAO {
    private Map<String, UserAuth> userAuthMap = new HashMap<>();

    @Override
    public Optional<UserAuth> getUserAuth(String userId) {
        return Optional.ofNullable(userAuthMap.get(userId));
    }
}
