package com.app.sistema.service.impl;

import com.app.sistema.model.Car;
import com.app.sistema.model.User;
import com.app.sistema.repository.CarRepository;
import com.app.sistema.repository.UserRepository;
import com.app.sistema.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    @Autowired
    private final CarRepository repository;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public List<Car> getAllCars() {
        return repository.getAllCars();
    }

    @Override
    public Car createCar(Car car) {
        User user = userRepository.findById(car.getUser().getId()).orElse(null);
        car.setUser(user);

        return repository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteCarById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Car updateCarById(Long id, Car updatedCar) {
        Car car = repository.findById(id).orElse(null);
        if(car != null){
            car.setCarYear(updatedCar.getCarYear());
            car.setColor(updatedCar.getColor());
            car.setModel(updatedCar.getModel());
            car.setLicensePlate(updatedCar.getLicensePlate());
            return repository.save(car);
        }
        return null;
    }

    @Override
    public boolean existsByLicensePlate(String licensePlate) {
        return repository.existsByLicensePlate(licensePlate);
    }

    @Override
    public List<Car> getCarByUserId(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return repository.findByUser(user);
        } else {
            return null; // Retorna null se o usuário não for encontrado
        }
    }
}
