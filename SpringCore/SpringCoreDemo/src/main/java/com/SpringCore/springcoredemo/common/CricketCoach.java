package com.SpringCore.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component  // marks class as Spring bean for dependency injection
@Lazy  // class is only initialized if needed for dependency injection or if requested
public class CricketCoach implements Coach {

    // Constructor
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
        // won't print unlessed needed since it has the @Lazy annotation
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }
}