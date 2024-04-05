package com.app.sistema.controller;

import com.app.sistema.model.Car;
import com.app.sistema.service.CarService;
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
class CarControllerTest {

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    @Test
    void testCreateCar() {
        Car car = new Car();
        car.setLicensePlate("ABC123");
        BindingResult bindingResult = new BeanPropertyBindingResult(car, "car");

        when(carService.existsByLicensePlate(any())).thenReturn(false);
        when(carService.createCar(any())).thenReturn(car);

        ResponseEntity<?> responseEntity = carController.createCar(car, bindingResult);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(car, responseEntity.getBody());
    }

    @Test
    void testCreateCarWithValidationErrors() {
        Car car = new Car();
        BindingResult bindingResult = createBindingResultWithErrors();

        ResponseEntity<?> responseEntity = carController.createCar(car, bindingResult);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        // Verifique se a resposta contém os erros esperados
    }

    // Método auxiliar para criar um BindingResult com erros de validação
    private BindingResult createBindingResultWithErrors() {
        BindingResult bindingResult = new BeanPropertyBindingResult(new Car(), "car");
        bindingResult.addError(new ObjectError("car", "License plate is required"));
        return bindingResult;
    }

    // Implemente testes para os métodos restantes do controller (getAllCars, getCarById, getCarByUserId, deleteCarById, updateCarById)
}

