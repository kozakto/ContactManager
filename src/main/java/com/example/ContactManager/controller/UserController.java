package com.example.ContactManager.controller;

import com.example.ContactManager.entity.Person;
import com.example.ContactManager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/addUser")
    public String addUser() {
        Person person = new Person();
        person.setFirstName("David");
        person.setLastName("Moravec");
        person.setAddress("Brno");
        person.setPhoneNumber("159");
        userRepository.save(person);
        logger.info("User info: {}", person);
        return ("User added");


    }


}
