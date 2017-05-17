package edu.hm.cs.swa.projekt_4.logic;

import edu.hm.cs.swa.projekt_4.datamodel.Token;
import edu.hm.cs.swa.projekt_4.datamodel.TokenFactory;
import edu.hm.cs.swa.projekt_4.datamodel.User;
import edu.hm.cs.swa.projekt_4.persistence.DataStore;

import java.util.Date;
import java.util.logging.Logger;

/**
 * this is an implementation of the {@linkplain AuthService} interface.
 */
public class AuthServiceImpl implements AuthService {

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
                user.setLastToken(TokenFactory.INSTANCE.createToken());
                return user.getActiveToken(invocationDate);
            }
        return null;
    }

    @Override
    public ValidationResult registerUser(User newUser) {
        DataStore.INSTANCE.addUser(newUser);
        return ValidationResult.CREATE_USER;
    }
}
