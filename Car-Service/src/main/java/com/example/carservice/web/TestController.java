package com.example.carservice.web;

import com.example.carservice.entities.User;
import com.example.carservice.services.UserAPI;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {
    private final UserAPI clientApi;

    public TestController(UserAPI clientApi) {
        this.clientApi = clientApi;
    }

    @GetMapping("/client/{id}")
    public User testClient(@PathVariable Long id) {
        return clientApi.findUserbyId(id);
    }
}