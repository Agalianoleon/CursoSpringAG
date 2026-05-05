package com.alejandro.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto getMethodName(@RequestParam(required = false, defaultValue = "No se ha recibido ningún mensaje") String message) {
        ParamDto paramDto = new ParamDto();
        //paramDto.setMessage(message!=null ? message : "No se ha recibido ningún mensaje");
        paramDto.setMessage(message);
        return paramDto;
    }
    
}
