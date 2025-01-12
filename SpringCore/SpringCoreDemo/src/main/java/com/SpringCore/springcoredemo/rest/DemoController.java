package com.SpringCore.springcoredemo.rest;

import com.SpringCore.springcoredemo.common.Coach;
import com.SpringCore.springcoredemo.common.TennisCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    private Coach anotherCoach;

//    // Dependency Injection with PROTOTYPE SCOPE
//    @Autowired
//    public DemoController(
//            @Qualifier("baseballCoach") Coach theCoach,  //  @Qualifier annotation specifies bean id (same as class but lower 1st char)
//            @Qualifier("baseballCoach") Coach theAnotherCoach) {  // two qualifiers to instaniate and injects two different baseball coach objects
//                // scope needs to not be singleton -> set on BaseballCoach class
//        System.out.println("In constructor: " + getClass().getSimpleName());
//
//        myCoach = theCoach;
//        anotherCoach = theAnotherCoach;
//    }

    // Dependency Injection with SINGLETON SCOPE
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach) {  //  @Qualifier annotation specifies bean id (same as class but lower 1st char)
                                   // tells it to use baseball Coach class specifically
        System.out.println("In constructor: " + getClass().getSimpleName());

        myCoach = theCoach;
    }

//    // Setter Injection
//    @Autowired
//    public void setCoach(Coach theCoach) {
//        myCoach = theCoach;
//    }

//    // SwimCoach is not a bean (missing @Component)
//    // Pulls from config with @Configuration and @Bean
//    @Autowired
//    public DemoController(@Qualifier("aquatic") Coach theCoach) {  // aquatic is the custom bean id
//        System.out.println("In constructor: " + getClass().getSimpleName());
//
//        myCoach = theCoach;
//    }

    // set dailyworkout endpoing so that it returns the getDailyWorkout method
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    // PROTOTYPE SCOPE: Check beans scope since there are 2 coach @Qualifiers
    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
                                                        // Singleton: true ; Prototype: false
    }
}
