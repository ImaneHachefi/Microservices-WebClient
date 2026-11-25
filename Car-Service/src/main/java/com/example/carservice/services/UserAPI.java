package com.example.carservice.services;

import com.example.carservice.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserAPI {
    private final WebClient.Builder webClientBuilder;

    public UserAPI(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public User findUserbyId(Long userId) {
        return webClientBuilder.build().get().uri("http://User-Service/api/users/"+ userId).retrieve().bodyToMono(User.class).block();

    }
}
