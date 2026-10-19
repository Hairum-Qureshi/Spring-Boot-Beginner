package com.example.Spring_Boot_Beginner.user.entities;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements UserDetails {

    @Id
    private Long id;

    @Column(unique=true, nullable=false, length=100)
    private String username;
    
    @Column(unique=true, nullable=false)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean enabled;

    private String verificationCode;

    private LocalDateTime verificationCodeExpiresAt;
    
    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    
    @Override
    public boolean isAccountNonExpired() {
        // TODO - implement check functionality here
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO - implement check functionality here
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}