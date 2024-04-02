package com.app.sistema.service;


import com.app.sistema.model.JwtAuthentication;
import com.app.sistema.model.SignUp;
import com.app.sistema.model.Signin;

public interface AuthenticationService {
    JwtAuthentication signup(SignUp request);

    JwtAuthentication signin(Signin request);

    boolean existsByEmail(String email);

    boolean existsByLogin(String login);
}
