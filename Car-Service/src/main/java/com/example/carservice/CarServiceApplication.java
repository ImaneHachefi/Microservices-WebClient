package com.example.carservice;

import com.example.carservice.entities.Car;
import com.example.carservice.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(CarRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                Object[][] data = {
                        {"Dacia", "Logan", 1L},
                        {"Renault", "Clio", 1L},
                        {"Peugeot", "208", 2L},
                        {"Toyota", "Yaris", 3L},
                        {"Hyundai", "i10", 3L},
                        {"Volkswagen", "Golf", 4L},
                        {"Kia", "Picanto", 5L},
                        {"Fiat", "Tipo", 5L},
                        {"Citroën", "C3", 6L},
                        {"Ford", "Fiesta", 6L}
                };

                for (Object[] d : data) {
                    Car c = new Car();
                    c.setMarque((String) d[0]);
                    c.setModele((String) d[1]);
                    c.setUserId((Long) d[2]);
                    repo.save(c);
                }
            }
        };
    }
}