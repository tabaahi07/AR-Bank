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

    @Override
    public void setUserAuth(UserAuth userAuth){
        userAuthMap.put(userAuth.getUserId() , userAuth) ;
    }

    public Boolean accountCreationAuth(String customerId , String accessToken){
        if(userAuthMap.get(customerId).getAccessToken() != accessToken) return false ;
        return true ;
    }
}
