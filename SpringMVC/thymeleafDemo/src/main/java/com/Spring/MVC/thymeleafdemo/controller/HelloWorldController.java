package com.Spring.MVC.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")  // method name is arbitrary (doesn't have to match endpoint or html name
    public String showForm() {
        return "helloworld-form";  // references helloworld-form.html
    }

//    // restricts this to only GET methods
//    @GetMapping("/showForm")
//    public String showForm() {
//        return "helloworld-form";
//    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // read the request parameter from the HTML form (grab value from form textbox)
        String theName = request.getParameter("studentName");  // studentName is the name of the inputted value from the form

        // convert data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;  // set result as the string message to pass back to the html

        // add message to the model
        model.addAttribute("message", result);  // message = name ; result = value on the html

        return "helloworld";
    }

    // can condense the code above to bind studentName input to theName variable
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
                                // takes studentName inputted parameter and binds it to theName String
        // convert data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey Friend, " + theName;  // set result as the string message to pass back to the html

        // add message to the model
        model.addAttribute("message", result);  // message = name ; result = value on the html

        return "helloworld";
    }
}
