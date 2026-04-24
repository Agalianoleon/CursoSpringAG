package com.alejandro.curso.springboot.webapp.springboot_web.models.dto;

import com.alejandro.curso.springboot.webapp.springboot_web.models.User;

public class UserDto {

    private String title;
    // objeto anidado se pueden tener sus propiedades dentro del dto en lugar de tener un objeto anidado
    private User user;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}
