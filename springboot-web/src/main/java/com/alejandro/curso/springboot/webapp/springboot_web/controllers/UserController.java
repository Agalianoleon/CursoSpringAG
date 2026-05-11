package com.alejandro.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alejandro.curso.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Alejandro", "Galiano");
        model.addAttribute("title", "Hola mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
    
        //model.addAttribute("users" , users);
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")// con esta anotacion se agrega el atributo a todos los modelos de este controlador
    public List<User> usersModel(){
        return Arrays.asList(
            new User("Alejandro", "Galiano"),
            new User("John", "Doe", "john.doe@example.com"),
            new User("Jane", "Smith", "jane.smith@example.com"),
            new User("Alice", "Johnson"));
    }
    

}
