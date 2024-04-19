package com.app.sos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/cadastro")
    public String cadastreNewUser(){
        return "cadastro";
    }
}
