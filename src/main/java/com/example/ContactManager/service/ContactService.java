package com.example.ContactManager.service;

import com.example.jooq.generated.tables.Person;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContactService {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public void fetchContacts() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            DSLContext create = DSL.using(connection);
            Result<Record> records = create.fetch("SELECT ID, FIRST_NAME, LAST_NAME, ADDRESS FROM PERSON");

            for (Record record : records) {
                Long id = record.get(Person.PERSON.ID);
                String firstName = record.get(Person.PERSON.FIRST_NAME);
                String lastName = record.get(Person.PERSON.LAST_NAME);
                String address = record.get(Person.PERSON.ADDRESS);

                System.out.println("ID: " + id + ", First name: " + firstName + ", Last name: " + lastName + ", Address: " + address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}