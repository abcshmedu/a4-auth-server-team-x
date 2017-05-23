package edu.hm.cs.swa.projekt_4.persistence;

import java.util.List;

import edu.hm.cs.swa.projekt_4.datamodel.Authorization;
import edu.hm.cs.swa.projekt_4.datamodel.AuthorizationGroup;
import edu.hm.cs.swa.projekt_4.datamodel.User;

public interface IDataStore {
    public List<User> getUsers() ;

    public void addUser(User user);

    public User userExists(String username, String password);
    
    public void addAuthorization(Authorization authorization);
    
    public List<Authorization> getAllAuthorizations();
    
    public void addAuthorizationGroup(AuthorizationGroup group);
    
    public List<AuthorizationGroup> getAllAuthorizationGroups();
    
    public User getUserForToken(String tokenID);
}
