package com.example.springexample;

public class UserManager {
public String getUserData() {
        UserDatabase userDatabase = new UserDatabase();
        return userDatabase.getUserData();
    }
}
