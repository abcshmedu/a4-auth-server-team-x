package edu.hm.cs.swa.projekt_4.datamodel;

import java.util.List;

public class User {

	
	private String username;
	private String password;
	
	private Token activeToken;
	
	private List<AuthorizationGroup> authGroup;
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}



	public String getPassword() {
		return password;
	}



	public Token getActiveToken() {
		return activeToken;
	}



	public void setActiveToken(Token activeToken) {
		this.activeToken = activeToken;
	}



	public List<AuthorizationGroup> getAuthGroup() {
		return authGroup;
	}



	public void setAuthGroup(List<AuthorizationGroup> authGroup) {
		this.authGroup = authGroup;
	}
	
	
	
}
