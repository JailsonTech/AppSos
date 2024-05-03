package com.app.sos.controller;
import com.app.sos.model.User;
import com.app.sos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

   

    //......ACESSAR AS PÁGINAS HTML ATRAVÉS DE LINKS OU NO..............

    @GetMapping("/")
    public String pagIndex(){ return "index"; }

    @GetMapping("/login")
    public String pagLogin(){ return "login"; }

    @GetMapping("/home")
    public String pagHome(){ return "home";  }

    @GetMapping("/imc")
    public String pagImc(){ return "imc"; }

    @GetMapping("/resultado")
    public String pagResultado(){ return "resultadoImc"; }

    @GetMapping("/lista")
    public String paglistUsers(){ return "listUsers"; }


//........MOSTRAR PÁGINA CADASTRO
    @GetMapping("/cadastro")
    public String mostrarFormulario(User user) {
        return "cadastro";
    }
    //........SALVAR USUÁRIOS NO BANCO
    @PostMapping("/salvar")
    public String salvarUsuario(User user) {
        userRepository.save(user);
        return "listUsers";
    }
    //........MOSTRAR USUÁRIOS CADASTRADOS
    @GetMapping("/mostrar")
    public String mostrarUsuarios(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "listUsers";
    }

}