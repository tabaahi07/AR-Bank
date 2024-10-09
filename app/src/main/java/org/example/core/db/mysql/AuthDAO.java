package org.example.core.db.mysql;

import org.example.core.dao.IAuthDAO;
import java.util.Optional;
import org.example.core.data.UserAuth;

public class AuthDAO implements IAuthDAO {
        @Override
        public Optional<UserAuth> getUserAuth(String userId) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getUserAuth'");
        }
}
