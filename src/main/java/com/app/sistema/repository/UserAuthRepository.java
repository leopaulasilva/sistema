package com.app.sistema.repository;

import com.app.sistema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<User, Integer> {
    // Since email is unique, we'll find users by email
    Optional<User> findByLogin(String login);

    boolean existsByEmail(String email);

    boolean existsByLogin(String login);
}
