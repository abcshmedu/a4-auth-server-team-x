package edu.hm.cs.swa.projekt_4.datamodel;

import java.util.Date;
import java.util.List;

public class User {


    private String username;
    private String password;

    private Token lastToken;

    private List<AuthorizationGroup> authGroup;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public Token getLastToken() {
        return lastToken;
    }

    public Token getActiveToken(Date checkDate) {
        if (getLastToken() != null && getLastToken().isValid(checkDate))
            return getLastToken();
        return null;
    }

    public void setLastToken(Token lastToken) {
        this.lastToken = lastToken;
    }

    public List<AuthorizationGroup> getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(List<AuthorizationGroup> authGroup) {
        this.authGroup = authGroup;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastToken=" + lastToken +
                ", authGroup=" + authGroup +
                '}';
    }
}
