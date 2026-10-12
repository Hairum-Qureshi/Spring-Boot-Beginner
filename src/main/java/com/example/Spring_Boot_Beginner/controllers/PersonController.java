package com.example.Spring_Boot_Beginner.controllers;
import com.example.Spring_Boot_Beginner.entities.Person;
import com.example.Spring_Boot_Beginner.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {

        Person savedPerson = personService.createPerson(person);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedPerson);
    }

    @GetMapping("/all")
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
    
    @GetMapping("/find/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePersonById(@PathVariable Long id) {
        personService.deletePersonById(id);
        return ResponseEntity.ok(Map.of("deleted", true));
    }


}