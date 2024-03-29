package com.app.sistema.controller;

import com.app.sistema.model.Car;
import com.app.sistema.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private final CarService service;

    public CarController(CarService service) {
        super();
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAllCars() {
        return ResponseEntity.ok(service.getAllCars());
    }

    @PostMapping
    public ResponseEntity<?> createCar(@Valid @RequestBody Car car, BindingResult result) {


        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        // Verificar se o e-mail já existe
        if (service.existsByLicensePlate(car.getLicensePlate())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("License plate already exists");
        }


            Car createdCar = service.createCar(car);
            return ResponseEntity.ok(createdCar);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCarById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable Long id) {
        service.deleteCarById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCarById(@PathVariable Long id, @RequestBody Car updatedCar) {
        return ResponseEntity.ok(service.updateCarById(id,updatedCar));
    }

}