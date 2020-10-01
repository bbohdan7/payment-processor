package ua.gov.bank.controllers;

import ua.gov.bank.services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class MainController {

    @Inject
    private UserService service;

    @PostConstruct
    public void init() {
        if(service == null){
            System.out.println("* * * This is null * * *");
        } else {
            System.out.println("* * NOT NULL * * ");
        }

        System.out.println("Printing out all of the users");
        service.all().forEach(System.out::println);
    }
}
