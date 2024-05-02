package com.app.sos.controller;
import com.app.sos.model.User;
import com.app.sos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

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

    @GetMapping("cadastro")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "cadastro";
    }

    //...................ENVIAR DADOS PARA O DATABASE.................

    @PostMapping("/enviar")
    public ModelAndView cadastrar(User user) {
        // Salvando o usuário no banco de dados
        userRepository.save(user);
        // Criando uma ModelAndView para retornar a uma página de login
        return new ModelAndView("listUsers");
    }

    //........MOSTRAR OS DADOS DOS USUÁRIOS CADASTRADOS...........

    @GetMapping("/listUsers")
    public String dadosUsers() {
        return "listUsers";
    }

    @GetMapping("/dadosUsers")
    public ModelAndView mostrarDados() {
        ModelAndView modelAndView = new ModelAndView("listUsers");
        modelAndView.addObject("users", userRepository.findAll());
        return modelAndView;
    }

}