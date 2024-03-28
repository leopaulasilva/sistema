package com.app.sistema.service;

import com.app.sistema.model.Car;
import com.app.sistema.model.User;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();

    Car createCar(Car car);

    Car getCarById(Long id);

    void deleteCarById(Long id);

    Car updateCarById(Long id, Car updatedCar);

    boolean existsByLicensePlate(String licensePlate);
}
