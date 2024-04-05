package com.app.sistema.controller;

import com.app.sistema.model.JwtAuthentication;
import com.app.sistema.model.SignUp;
import com.app.sistema.model.Signin;
import com.app.sistema.service.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authenticationController;

    @Test
    void testSignup() {
        SignUp signUp = new SignUp();
        signUp.setEmail("test@example.com");
        signUp.setLogin("testuser");
        BindingResult bindingResult = new BeanPropertyBindingResult(signUp, "signUp");

        when(authenticationService.existsByEmail(any())).thenReturn(false);
        when(authenticationService.existsByLogin(any())).thenReturn(false);
        JwtAuthentication jwtAuthentication = JwtAuthentication.builder().token("jwtToken").build(); // Criar um JwtAuthentication com um token
        when(authenticationService.signup(any())).thenReturn(jwtAuthentication); // Configurar o retorno do mock

        ResponseEntity<?> responseEntity = authenticationController.signup(signUp, bindingResult);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(jwtAuthentication, responseEntity.getBody());
    }

    @Test
    void testSignupWithValidationErrors() {
        SignUp signUp = new SignUp();
        BindingResult bindingResult = createBindingResultWithErrors();

        ResponseEntity<?> responseEntity = authenticationController.signup(signUp, bindingResult);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        // Verifique se a resposta contém os erros esperados
    }

    @Test
    void testSignin() {
        Signin signin = new Signin();
        signin.setLogin("test@example.com");
        signin.setPassword("password");
        BindingResult bindingResult = new BeanPropertyBindingResult(signin, "signin");

        JwtAuthentication jwtToken = JwtAuthentication.builder().token("jwtToken").build();
        when(authenticationService.signin(any())).thenReturn(jwtToken);

        ResponseEntity<?> responseEntity = authenticationController.signin(signin, bindingResult);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(jwtToken, responseEntity.getBody());
    }


    private BindingResult createBindingResultWithErrors() {
        BindingResult bindingResult = new BeanPropertyBindingResult(new SignUp(), "signUp");
        bindingResult.addError(new ObjectError("signUp", "Email is required"));
        return bindingResult;
    }
}
