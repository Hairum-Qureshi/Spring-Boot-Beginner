package com.example.Spring_Boot_Beginner.repositories;
import com.example.Spring_Boot_Beginner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);  
    Optional<User> findByVerificationCode(String verificationCode);

}