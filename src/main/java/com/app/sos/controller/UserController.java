package com.app.sos.controller;
import com.app.sos.model.User;
import com.app.sos.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

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

//........RETORNO E PERSISTÊNCIA DE DADOS............
    @GetMapping("/cadastro")
    public String newUser(Model model){   //......método model do spring
        User user = new User();   //......criado objeto "user"
        model.addAttribute("newUser", user);//......"newUser" será o "object" do formulário
        return "/cadastro";
    }

//........SALVAR USUÁRIOS NO BANCO
    @PostMapping("/salvar")
    public String salvarUser(Model model, @ModelAttribute("newUser") @Valid User user,  BindingResult erros, RedirectAttributes attributes) {

        if (erros.hasErrors()) {
            return "/cadastro";
        }
    model.addAttribute("mensagem", "Cadastro realizado!");

    userService.criarUser(user);
    return "/cadastro";
    }
}