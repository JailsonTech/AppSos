package com.app.sos.controller;

import com.app.sos.entities.Imc;
import com.app.sos.entities.Users;
import com.app.sos.repositories.UserRepository;
import com.app.sos.services.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String index(){
        return "index";
    }    
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
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
    
    //........MAPPING DO IMC.......................

    private ImcService imcService;

    //Chamada do método calcular da entidade Imc
    Imc calculo = new Imc();
    
    @GetMapping("/imc")
    public ModelAndView calc(){
        ModelAndView  pegar = new ModelAndView();
        ModelAndView calculoimc = pegar.addObject("calculoimc", calculo);
        pegar.setViewName("/imc");
        return pegar;
    }

    @PostMapping("/calcularImc")
    public ModelAndView calculo(@RequestParam("peso") double peso, @RequestParam("altura") double altura){
        ModelAndView resultado = new ModelAndView();

        // Realizar o cálculo do IMC
        double imc = peso / (altura * altura);

        // Adicionar o IMC ao ModelAndView
        resultado.addObject("calculoimc", imc);

        // Definir o nome da view
        resultado.setViewName("home");

        return resultado;
    }

    public class Calculo {
        private double peso;
        private double altura;
        private double resultado;

        public double getPeso() {
            return peso;
        }

        public void setPeso(double peso) {
            this.peso = peso;
        }

        public double getAltura() {
            return altura;
        }

        public void setAltura(double altura) {
            this.altura = altura;
        }

        public double getResultado() {
            return resultado;
        }

        public void setResultado(double resultado) {
            this.resultado = resultado;
        }
    }
}
