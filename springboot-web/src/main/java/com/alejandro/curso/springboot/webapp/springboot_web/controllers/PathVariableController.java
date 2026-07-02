package com.alejandro.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.webapp.springboot_web.models.User;
import com.alejandro.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
    private List<String> listOfValues;
    
    @Value("${config.code}")
    private Integer code;

    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    @Autowired
    private Environment enviroment;

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
       json.put("message2", enviroment.getProperty("config.message"));
       json.put("code2", enviroment.getProperty("config.code", Long.class));
       json.put("listOfValues", listOfValues);
       json.put("valueList", valueList);
       json.put("valueString", valueString);
       json.put("valueMap", valuesMap);
       json.put("product", product);
       json.put("price", price);
       return json;
    }
    
}