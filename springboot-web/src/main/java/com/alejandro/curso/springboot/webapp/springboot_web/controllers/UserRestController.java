package com.alejandro.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.webapp.springboot_web.models.User;
import com.alejandro.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details() {
        UserDto userDto = new UserDto();
        User user = new User("Alejandro", "Galiano");
        userDto.setUser(user);
        userDto.setTitle("Hola mundo Spring Boot");
        return userDto;
    }

    @GetMapping("/details")
    public Map<String,Object> detailsMap() {
        User user = new User("Alejandro", "Galiano");
        Map<String,Object> body = new HashMap<>();
        body.put("title", "Hola mundo Spring Boot");
        body.put("user", user);
        return body;
    }
}
