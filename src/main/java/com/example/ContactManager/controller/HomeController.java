package com.example.ContactManager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    public String home() {

        logger.info("Home method accessed");
        return "Welcome to Contact Manager!";
    }
}