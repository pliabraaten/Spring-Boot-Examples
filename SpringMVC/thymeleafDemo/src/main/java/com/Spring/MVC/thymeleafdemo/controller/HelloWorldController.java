package com.Spring.MVC.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")  // method name is arbitrary (doesn't have to match endpoint or html name
    public String showForm() {
        return "helloworld-form";  // references helloworld-form.html
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
}
