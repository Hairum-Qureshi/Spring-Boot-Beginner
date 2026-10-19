package com.example.Spring_Boot_Beginner.user;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class UserController {

    private final UserService personService;

    public UserController(UserService personService) {
        this.personService = personService;
    }

 


}