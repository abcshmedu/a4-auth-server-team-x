package edu.hm.cs.swa.projekt_4.rest;

import edu.hm.cs.swa.projekt_4.datamodel.Token;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by christian on 28.05.17.
 */
public class ValidationServiceRESTTest {
    private final String authId = "media.book.create";

    @Test
    public void validateTokenNoTokenId() throws Exception {
        ValidationServiceREST val = new ValidationServiceREST();

        Response response = val.validateToken("", authId);

        assertEquals(404, response.getStatus());
    }

    public void validateToken() throws Exception {
        ValidationServiceREST val = new ValidationServiceREST();

        AuthServiceREST auth = new AuthServiceREST();
        Response authResponse = auth.authUser("user1", "asd");

        Token t = (Token) authResponse.getEntity();

        Response response = val.validateToken(t.getID(), authId);
        assertEquals(200, response.getStatus());
    }

}