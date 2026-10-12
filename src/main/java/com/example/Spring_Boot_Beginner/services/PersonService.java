package com.example.Spring_Boot_Beginner.services;
import com.example.Spring_Boot_Beginner.entities.Person;
import com.example.Spring_Boot_Beginner.repositories.PersonRepository;
import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person createPerson(Person person) {

        if(person.getFirstName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "First name cannot be blank");
        }

        if(person.getLastName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Last name cannot be blank");
        }

        // Generate unique ID
        person.setId(TsidCreator.getTsid().toLong());

        // Persist entity in Neon PostgreSQL
        return personRepository.save(person);
    }
    
    @Transactional
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }
    
    @Transactional
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @Transactional
    public void deletePersonById(Long id) {
        if (!personRepository.existsById(id)) throw new RuntimeException("Person not found");
        
        personRepository.deleteById(id);
    }
}
