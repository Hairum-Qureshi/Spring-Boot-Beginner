package com.example.Spring_Boot_Beginner.services;
import com.example.Spring_Boot_Beginner.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PersonRepository personRepository;

    public UserService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

//    @Transactional
   
}
