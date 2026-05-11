package com.alejandro.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.alejandro.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

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
    
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, 
                        @RequestParam Integer code){

        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){
        Integer code = 0;
        try{
            Integer.parseInt(request.getParameter("code"));
        }catch(NumberFormatException e){
        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;        
    }
    


}
