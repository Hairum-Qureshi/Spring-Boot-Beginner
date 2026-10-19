package com.example.Spring_Boot_Beginner.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByVerificationCode(String verificationCode);

}