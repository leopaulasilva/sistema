package com.app.sistema.repository;

import com.app.sistema.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByLicensePlate(String licensePlate);

    @Query("SELECT c FROM Car c JOIN FETCH c.user")
    List<Car> getAllCars();


    boolean existsByLicensePlate(String licensePlate);
}
