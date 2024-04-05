package com.app.sistema.controller;

import com.app.sistema.model.User;
import com.app.sistema.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetAllUsers() {

        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("John Doe");
        userList.add(user1);
        when(userService.getAllUsers()).thenReturn(userList);

        ResponseEntity<?> responseEntity = userController.getAllUsers();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(userList, responseEntity.getBody());
    }

    @Test
    void testCreateUser() {
        User user = new User();

        BindingResult bindingResult = new BeanPropertyBindingResult(user, "user");

        ResponseEntity<?> responseEntity = userController.createUser(user, bindingResult);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }


    @Test
    void testCreateUserWithValidationErrors() {
        User user = new User();

        BindingResult bindingResult = createBindingResultWithErrors();

        ResponseEntity<?> responseEntity = userController.createUser(user, bindingResult);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    private BindingResult createBindingResultWithErrors() {
        User user = new User();
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.afterPropertiesSet();

        BindingResult bindingResult = new BeanPropertyBindingResult(user, "user");
        validator.validate(user, bindingResult);


        bindingResult.addError(new FieldError("user", "firstName", "First name is too short"));

        return bindingResult;
    }
}
