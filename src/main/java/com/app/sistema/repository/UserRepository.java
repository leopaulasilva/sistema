package com.app.sistema.repository;

import com.app.sistema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    boolean existsByEmail(String email);

    boolean existsByLogin(String login);
}
