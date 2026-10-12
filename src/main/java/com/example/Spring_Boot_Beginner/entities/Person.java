package com.example.Spring_Boot_Beginner.entities;

import com.example.Spring_Boot_Beginner.enums.Gender;
import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    // Default constructor (required by JPA)
    public Person() {}

    // Getters
    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Gender getGender() {
        return this.gender;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}