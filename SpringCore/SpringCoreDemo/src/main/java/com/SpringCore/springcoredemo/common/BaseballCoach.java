package com.SpringCore.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  // marks class as Spring bean for dependency injection
//@Primary  // make this coach the primary in case the coach is not specified with a @Qualifier
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // sets beans scope to prototype so there will different objects when injected
public class BaseballCoach implements Coach{

    // Constructor
    public BaseballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

//    // define init method
//    @PostConstruct
//    public void doMyStartup() {
//        System.out.println("In doMyStartup(): " + getClass().getSimpleName());
//    }
//
//    // define destroy method
//    @PreDestroy
//    public void doMyCleanup() {
//        System.out.println("In doMyCleanup(): " + getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice!";
    }
}
