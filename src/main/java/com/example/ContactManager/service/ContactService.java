package com.example.ContactManager.service;

import com.example.jooq.generated.tables.Person;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ContactService {
    @Value("${spring.datasource.url}")
    private String URL;
    @Value("${spring.datasource.username}")
    private String USER;
    @Value("${spring.datasource.password}")
    private String PASSWORD;
    Logger logger = LoggerFactory.getLogger(ContactService.class);


    public void fetchContacts() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            DSLContext create = DSL.using(connection);
            Result<Record> records = create
                    .select()
                    .from(Person.PERSON).fetch();

            for (Record record : records) {
                logger.info("Record: " + record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}