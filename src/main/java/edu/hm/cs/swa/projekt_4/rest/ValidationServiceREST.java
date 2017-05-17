package edu.hm.cs.swa.projekt_4.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.hm.cs.swa.projekt_4.datamodel.Token;
import edu.hm.cs.swa.projekt_4.datamodel.ValidationResult;

@Path("validation")
public class ValidationServiceREST {

	 @GET
	    @Path("user")
	    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
		public ValidationResult validateUser(@QueryParam("token") Token token, 
							  	  			 @QueryParam("authorizationID") String authorizationID){
			
			
			return null;
		}
	
}
