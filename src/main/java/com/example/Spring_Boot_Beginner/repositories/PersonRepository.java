package com.example.Spring_Boot_Beginner.repositories;
import com.example.Spring_Boot_Beginner.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { }