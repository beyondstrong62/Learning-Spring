package com.example.IOC;

public class webserviceProvider implements UserDataProvider {

    @Override
    public String getUserDetails() {
        return "webservice provider: User data from the web service";
    }
}
