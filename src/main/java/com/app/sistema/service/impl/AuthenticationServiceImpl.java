package com.app.sistema.service.impl;

import com.app.sistema.enums.Role;
import com.app.sistema.model.JwtAuthentication;
import com.app.sistema.model.SignUp;
import com.app.sistema.model.Signin;
import com.app.sistema.model.User;
import com.app.sistema.repository.UserAuthRepository;

import com.app.sistema.service.AuthenticationService;
import com.app.sistema.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserAuthRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final MessageSource messageSource;

    private String getMessage(String messageCode, Object... args) {
        return messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
    }

    @Override
    public JwtAuthentication signup(SignUp request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .login(request.getLogin())
                .createdAt(LocalDateTime.now())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);

        var jwt = jwtService.generateToken(user);
        return JwtAuthentication.builder().token(jwt).build();
    }

    @Override
    public JwtAuthentication signin(Signin request) {
        var user = userRepository.findByLogin(request.getLogin())
                .orElseThrow(() -> new IllegalArgumentException(getMessage("message.login.error")));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), request.getPassword()));
        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthentication.builder().token(jwt).build();
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }
}