package com.example.IOC;

public class UserDatabaseProvider implements UserDataProvider {
    @Override
    public String getUserDetails() {
        return "User data from the database";

    }
}
