package com.example.ContactManager;

import com.example.ContactManager.service.ContactService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactManagerApplication {
    @Autowired
    private ContactService contactService;

    public static void main(String[] args) {
        SpringApplication.run(ContactManagerApplication.class, args);
    }

    @PostConstruct
    public void loadContacts() {
        contactService.fetchContacts();
    }

}
