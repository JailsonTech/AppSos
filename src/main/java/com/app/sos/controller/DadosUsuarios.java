package com.app.sos.controller;

import com.app.sos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class DadosUsuarios {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity repository(){
        return ResponseEntity.ok("Ok!");
    }
}
