package com.app.sos.controller;

import com.app.sos.entities.Users;
import com.app.sos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Users());
        mv.setViewName("/cadastro");
        return mv;
    }

    @PostMapping("/salvarUsers")
    public ModelAndView cadastrar(Users usuario){
        ModelAndView mv = new ModelAndView();
        repository.save(usuario);
        mv.setViewName("/login");
        return mv;
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}



