package edu.hm.cs.swa.projekt_4.persistence;

import edu.hm.cs.swa.projekt_4.datamodel.Authorization;
import edu.hm.cs.swa.projekt_4.datamodel.AuthorizationGroup;
import edu.hm.cs.swa.projekt_4.datamodel.User;

public class DefaultDataFactory {
	
	private static final String[] authorizations = new String[]{};

	public static void fillDefault(IDataStore dataStore){
		
		addAuthorizations(dataStore);
		
		addAuthorizationGroup(dataStore);
		
		addUser(dataStore);
		
		
	}
	

	
	private static void addAuthorizations(IDataStore dataStore){
		
		for(String auth : authorizations){
			Authorization newAuth = new Authorization(auth);
			dataStore.addAuthorization(newAuth);
		}
		
	}
	
	private static void addAuthorizationGroup(IDataStore dataStore){
		
		AuthorizationGroup newGroup = new AuthorizationGroup(dataStore.getAllAuthorizations());
		dataStore.addAuthorizationGroup(newGroup);
		
	}
	
	private static void addUser(IDataStore dataStore){
		
		User user1 = new User("user1", "asd");
		user1.addAuthGroup(dataStore.getAllAuthorizationGroups().get(0));
		dataStore.addUser(user1);
		
		User user2 = new User("user2", "asd");
		dataStore.addUser(user2);
		
		User user3 = new User("user3", "asd");
		dataStore.addUser(user3);
	}
}
