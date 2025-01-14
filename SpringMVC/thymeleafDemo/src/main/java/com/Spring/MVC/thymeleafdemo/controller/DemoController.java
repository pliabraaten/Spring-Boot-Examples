package com.Spring.MVC.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    // create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model theModel) {

        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        // Because of Thymeleaf dependency, Spring Boot will auto-config to use Thymeleaf
        return "helloworld";
        // Will look for src/main/resources/templates/helloworld.html

    }
}
