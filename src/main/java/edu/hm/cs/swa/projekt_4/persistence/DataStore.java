package edu.hm.cs.swa.projekt_4.persistence;

import edu.hm.cs.swa.projekt_4.datamodel.User;

import java.util.ArrayList;
import java.util.List;

public class DataStore {


    public static DataStore INSTANCE = new DataStore();

    private List<User> userList;

    public DataStore() {
        userList = new ArrayList<>();
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


}
