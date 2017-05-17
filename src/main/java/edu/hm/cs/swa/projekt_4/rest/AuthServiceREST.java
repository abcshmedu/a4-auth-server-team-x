package edu.hm.cs.swa.projekt_4.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.hm.cs.swa.projekt_4.datamodel.Token;

@Path("auth")
public class AuthServiceREST {

	
    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
	public Token authUser(@QueryParam("username") String username, 
						  @QueryParam("password") String password){
		
		
		return null;
	}
}
