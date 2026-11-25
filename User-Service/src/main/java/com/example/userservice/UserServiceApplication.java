package com.example.userservice;

import com.example.userservice.entities.User;
import com.example.userservice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(UserRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                String[][] data = {
                        {"Imane Hachefi", "imane@email.com", "28"},
                        {"Rania Et Thami", "rania@email.com", "22"},
                        {"Sara Benani", "sara@email.com", "25"},
                        {"Youssef Alami", "youssef@email.com", "30"},
                        {"Salma Idrissi", "salma@email.com", "27"},
                        {"Omar Tazi", "omar@email.com", "35"}
                };
                for (String[] d : data) {
                    User u = new User();
                    u.setName(d[0]);
                    u.setEmail(d[1]);
                    u.setAge(Float.parseFloat(d[2]));
                    repo.save(u);
                }
            }
        };
    }
}