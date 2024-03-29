package com.app.sistema.service;

import com.app.sistema.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
    User updateUserById(Long id, User updatedUser);


    boolean existsByEmail(String email);

    boolean existsByLogin(String login);
    UserDetailsService userDetailsService();
}
