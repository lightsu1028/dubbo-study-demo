package com.lightsu;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ImportResource(locations = {"classpath:provider.xml"})
@EnableDubbo
@SpringBootApplication
public class UserServiceProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApp.class, args);
    }
}
