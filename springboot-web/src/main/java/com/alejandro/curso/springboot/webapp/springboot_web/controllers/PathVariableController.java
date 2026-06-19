package com.alejandro.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.webapp.springboot_web.models.User;
import com.alejandro.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    @Value("${config.username}")
    private String username;
    /* @Value("${config.message}")
    private String message; */
    @Value("${config.listOfValues}")
    private String[] listOfValues;
    @Value("${config.code}")
    private Integer code;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }    
    //uso de pathVariable para recibir parametros en la url,el parametro se llama igual que 
    //el nombre de la variable en la url, si no se llama igual se puede usar @PathVariable("nombreParametro") para mapearlo
    @GetMapping("/mix/{product}/{id}")
    public Map<String,Object> mixPathVariable(@PathVariable String product,@PathVariable Integer id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }
    //ejemplo de peticion post para probar desde postman mandado un body
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        //Transformaciones 
        user.setName(user.getName().toUpperCase());
        return user;
    }
    
    @GetMapping("/values")
    public Map<String,Object> values(@Value("${config.message}")String message) {
       
       Map<String, Object> json = new HashMap<>();
       
       json.put("username", username);
       json.put("code", code);
       json.put("message", message);
       json.put("listOfValues", listOfValues);
       
       return json;
    }
    
}