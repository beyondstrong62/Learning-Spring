package com.example.IOC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExampleApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringExampleApplication.class, args);
//        UserManager userManager = new UserManager();
//        String userData = userManager.getUserData();
//        System.out.println(userData);
            UserDataProvider dataProvider = new UserDatabaseProvider();
            UserManager userManagerDB = new UserManager(dataProvider);
            System.out.println(userManagerDB.getUserInfo());

            UserDataProvider webserviceProvider = new webserviceProvider();
            UserManager userManagerWebservice = new UserManager(webserviceProvider);
            System.out.println(userManagerWebservice.getUserInfo());
    }

}
