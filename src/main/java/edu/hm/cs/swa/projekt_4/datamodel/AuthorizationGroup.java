package edu.hm.cs.swa.projekt_4.datamodel;

import java.util.List;

public class AuthorizationGroup {

	
	private List<Authorization> authList;
	
	
	public AuthorizationGroup(){
		
	}
	
	public AuthorizationGroup(List<Authorization> authList) {
		super();
		this.authList = authList;
	}




	public void addAuthorization(Authorization auth){
		this.authList.add(auth);
	}
	
	public boolean containsAuthorization(String id){
		
		for(Authorization auth : this.authList){
			if(auth.getId().equals(id)){
				return true;
			}
		}
		
		return false;
	}
}
