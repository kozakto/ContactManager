package com.example.ContactManager.repository;

import com.example.ContactManager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Person, Long> {

}