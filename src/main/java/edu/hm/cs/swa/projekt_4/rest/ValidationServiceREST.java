package edu.hm.cs.swa.projekt_4.rest;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hm.cs.swa.projekt_4.logic.IValidationService;
import edu.hm.cs.swa.projekt_4.logic.ValidationResult;
import edu.hm.cs.swa.projekt_4.logic.ValidationServiceImpl;

@Path("validate")
public class ValidationServiceREST {

	
    private Logger LOGGER = Logger.getLogger(ValidationServiceREST.class.getName());

    @GET
    @Path("token")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public Response validateToken(@QueryParam("tokenID") String tokenID,
                             	  @QueryParam("authID") String authID) {
    	
    	IValidationService service = new ValidationServiceImpl();
    	
        ValidationResult result = service.validateToke(tokenID, authID);

        if (result != null)
            return Response.ok(result).build();
        return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
    }
}
