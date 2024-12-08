package com.example.ContactManager.controller;

import com.example.ContactManager.entity.Person;
import com.example.ContactManager.repository.UserRepository;
import com.example.ContactManager.service.ContactService;
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
    @Autowired
    private ContactService contactService;

    @GetMapping("/addUser")
    public String addUser() {
        Person person = new Person();
        person.setFirstName("Jana");
        person.setLastName("Nová");
        person.setAddress("Plzen");
        person.setPhoneNumber("135");
        userRepository.save(person);
        logger.info("User info: {}", person);
        return ("User added");
    }

    @GetMapping("/contacts")
    public void loadContacts() {
        contactService.fetchContacts();
        logger.info("Contacts loaded.");
    }

}
