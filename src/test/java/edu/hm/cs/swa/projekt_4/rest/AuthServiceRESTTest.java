package edu.hm.cs.swa.projekt_4.rest;

import edu.hm.cs.swa.projekt_4.datamodel.Token;
import edu.hm.cs.swa.projekt_4.datamodel.User;
import edu.hm.cs.swa.projekt_4.persistence.DataStore;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by christian on 28.05.17.
 */
public class AuthServiceRESTTest {
    private final String username = "testu";
    private final String password = "testp";
    private final String usernameDefault = "user1";
    private final String passwordDefault = "asd";

    @Test
    public void authUserNotExists() throws Exception {
        AuthServiceREST auth = new AuthServiceREST();
        DataStore.INSTANCE.reset();

        Response response = auth.authUser(username, password);

        assertEquals(403, response.getStatus());
    }

    @Test
    public void authUserExists() throws Exception {
        AuthServiceREST auth = new AuthServiceREST();
        DataStore.INSTANCE.reset();

        Response response = auth.authUser(usernameDefault, passwordDefault);
        assertEquals(200, response.getStatus());

        Object o = response.getEntity();
        assertTrue(o instanceof Token);

        Token token = (Token) o;

        assertTrue(token.isValid(new Date()));
        assertEquals(12, token.getID().length());


    }

    @Test
    public void registerUser() throws Exception {
        AuthServiceREST auth = new AuthServiceREST();

        DataStore.INSTANCE.reset();

        User testUser = new User(username, password);
        Response response = auth.registerUser(testUser);

        assertEquals(201, response.getStatus());
    }

    @Test
    public void registerUserFalse() throws Exception {
        AuthServiceREST auth = new AuthServiceREST();

        DataStore.INSTANCE.reset();

        User testUser = new User(username, null);
        Response response = auth.registerUser(testUser);

        assertEquals(400, response.getStatus());
    }

}