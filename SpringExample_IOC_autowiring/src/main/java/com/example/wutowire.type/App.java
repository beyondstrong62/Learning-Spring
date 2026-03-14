package com.example.wutowire.type;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("ranaautowire_type.xml");
        Car myCar = (Car) context.getBean("myCar");
        myCar.displayDetails();
    }
}
