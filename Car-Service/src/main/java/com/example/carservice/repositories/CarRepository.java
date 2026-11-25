package com.example.carservice.repositories;

import com.example.carservice.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByUserId(Long userId);
}
