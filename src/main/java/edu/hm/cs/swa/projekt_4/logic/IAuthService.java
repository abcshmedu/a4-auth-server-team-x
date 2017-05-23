package edu.hm.cs.swa.projekt_4.logic;

import edu.hm.cs.swa.projekt_4.datamodel.Token;
import edu.hm.cs.swa.projekt_4.datamodel.User;

/**
 * This interface describes all available methods of our business logic.
 */
public interface IAuthService {

    public Token authUser(String username, String password);

    public ValidationResult registerUser(User newUser);
}
