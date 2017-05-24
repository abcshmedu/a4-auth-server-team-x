package edu.hm.cs.swa.projekt_4.persistence;

import edu.hm.cs.swa.projekt_4.datamodel.Authorization;
import edu.hm.cs.swa.projekt_4.datamodel.AuthorizationGroup;
import edu.hm.cs.swa.projekt_4.datamodel.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DataStore implements IDataStore {

    public static DataStore INSTANCE = new DataStore();

    private List<User> userList;
    private List<Authorization> authorizationList;
    private List<AuthorizationGroup> authorizationGroupList;

    private DataStore() {
        userList = new ArrayList<>();
        authorizationGroupList = new ArrayList<>();
        authorizationList = new ArrayList<>();
    }

    public List<User> getUsers() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User userExists(String username, String password) {
        return userList.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst().orElse(null);
    }

    @Override
    public void addAuthorization(Authorization authorization) {
        this.authorizationList.add(authorization);

    }

    @Override
    public List<Authorization> getAllAuthorizations() {
        return this.authorizationList;
    }

    @Override
    public void addAuthorizationGroup(AuthorizationGroup group) {
        this.authorizationGroupList.add(group);

    }

    @Override
    public List<AuthorizationGroup> getAllAuthorizationGroups() {
        return this.authorizationGroupList;
    }

    @Override
    public User getUserForToken(String tokenID) {


        User foundUser = null;
        Iterator<User> it = userList.iterator();

        while (foundUser == null && it.hasNext()) {

            User tempUser = it.next();

            if (tempUser.getLastToken() != null && tempUser.getLastToken().getID().equals(tokenID) &&
                    tempUser.getActiveToken(new Date()) != null) {
                foundUser = tempUser;
            }


        }

        return foundUser;
    }


}
