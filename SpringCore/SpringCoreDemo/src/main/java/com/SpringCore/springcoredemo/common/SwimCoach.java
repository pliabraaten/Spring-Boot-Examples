package com.SpringCore.springcoredemo.common;

// Not using @Component
public class SwimCoach implements Coach {

    public SwimCoach () {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 100 meters as a warm up";
    }
}
