package edu.hm.cs.swa.projekt_4.logic;

import edu.hm.cs.swa.projekt_4.datamodel.Token;
import edu.hm.cs.swa.projekt_4.datamodel.TokenFactory;
import edu.hm.cs.swa.projekt_4.datamodel.User;
import edu.hm.cs.swa.projekt_4.persistence.DataStore;

import java.util.Date;
import java.util.logging.Logger;

/**
 * this is an implementation of the {@linkplain IAuthService} interface.
 */
public class AuthServiceImpl implements IAuthService {

    private Logger LOGGER = Logger.getLogger(AuthServiceImpl.class.getName());

    @Override
    public Token authUser(String username, String password) {
        LOGGER.info("authUser accessed with username: " + username + ", password: " + password);
        Date invocationDate = new Date();
        User user = DataStore.INSTANCE.userExists(username, password);
        if (user != null)
            if (user.getActiveToken(invocationDate) != null)
                return user.getActiveToken(invocationDate);
            else {
                Token newToken = TokenFactory.INSTANCE.createToken();
                user.setLastToken(newToken);
                return newToken;
            }
        return null;
    }

    @Override
    public ValidationResult registerUser(User newUser) {
        if (newUser == null || newUser.getPassword() == null || newUser.getPassword().isEmpty() || newUser.getUsername() == null || newUser.getUsername().isEmpty())
            return ValidationResult.CREATE_USER_FAILED;
        newUser.addAuthGroup(DataStore.INSTANCE.getAllAuthorizationGroups().get(0));
        DataStore.INSTANCE.addUser(newUser);
        return ValidationResult.CREATE_USER;
    }
}
