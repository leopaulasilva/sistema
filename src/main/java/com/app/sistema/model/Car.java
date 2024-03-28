package com.app.sistema.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Evita a serialização do proxy Hibernate
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_year")
    private int carYear;
    @NotEmpty(message = "LicensePlate cannot be empty")
    private String licensePlate;
    @NotEmpty(message = "Model cannot be empty")
    private String model;
    @NotEmpty(message = "Color cannot be empty")
    private String color;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("cars")
    @JoinColumn(name = "user_id")
    private User user;
}
