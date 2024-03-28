package com.app.sistema.controller;

import com.app.sistema.model.User;
import com.app.sistema.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result) {
        // Verificar erros de validação
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        // Verificar se o e-mail já existe
        if (service.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }

        // Verificar se o login já existe
        if (service.existsByLogin(user.getLogin())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login already exists");
        }
        return ResponseEntity.ok(service.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        service.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>  updateUserById(@Valid @PathVariable Long id, @RequestBody User updatedUser, BindingResult result) {
        // Verificar erros de validação
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        // Verificar se o e-mail já existe
        if (service.existsByEmail(updatedUser.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }

        // Verificar se o login já existe
        if (service.existsByLogin(updatedUser.getLogin())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login already exists");
        }
        return ResponseEntity.ok(service.updateUserById(id,updatedUser));
    }
}