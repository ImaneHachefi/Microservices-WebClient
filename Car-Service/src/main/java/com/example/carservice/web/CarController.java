package com.example.carservice.web;

import com.example.carservice.entities.Car;
import com.example.carservice.repositories.CarRepository;
import com.example.carservice.services.UserAPI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository repo;
    private final UserAPI userApi;

    public CarController(CarRepository repo, UserAPI userApi) {
        this.repo = repo;
        this.userApi = userApi;
    }

    @PostMapping
    public Car save(@RequestBody Car car) {
        // Sauvegarde uniquement la voiture (DB locale carservicedb)
        return repo.save(car);
    }

    @GetMapping
    public List<Car> findAll() {
        List<Car> cars = repo.findAll();

        // Enrichissement : pour chaque voiture, récupérer le user
        for (Car car : cars) {
            if (car.getUserId() != null) {
                car.setUser(userApi.findUserbyId(car.getUserId()));
            }
        }
        return cars;
    }

    @GetMapping("/byUser/{userId}")
    public List<Car> findByUser(@PathVariable Long userId) {
        List<Car> cars = repo.findByUserId(userId);

        // Même user pour toutes les voitures de ce userId
        for (Car car : cars) {
            car.setUser(userApi.findUserbyId(userId));
        }
        return cars;
    }
}