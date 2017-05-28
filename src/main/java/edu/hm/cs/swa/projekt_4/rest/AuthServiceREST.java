package edu.hm.cs.swa.projekt_4.rest;

import edu.hm.cs.swa.projekt_4.datamodel.Token;
import edu.hm.cs.swa.projekt_4.datamodel.User;
import edu.hm.cs.swa.projekt_4.logic.AuthServiceImpl;
import edu.hm.cs.swa.projekt_4.logic.IAuthService;
import edu.hm.cs.swa.projekt_4.logic.ValidationResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("auth")
public class AuthServiceREST {


    private Logger LOGGER = Logger.getLogger(AuthServiceREST.class.getName());

    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public Response authUser(@QueryParam("username") String username,
                             @QueryParam("password") String password) {

        LOGGER.info("rest request: auth User username: " + username + ", password: " + password);
        IAuthService service = new AuthServiceImpl();

        Token result = service.authUser(username, password);
        if (result != null)
            return Response.ok(result).build();
        return Response.status(ValidationResult.AUTHORIZATION_MISSING.getStatus()).entity(ValidationResult.AUTHORIZATION_MISSING).build();
    }

    @POST
    @Path("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public Response registerUser(User newUser) {
        LOGGER.info("rest request: register User");
        IAuthService service = new AuthServiceImpl();

        ValidationResult result = service.registerUser(newUser);

        return Response.status(result.getStatus()).entity(result).build();
    }
}
