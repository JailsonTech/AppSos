package com.app.sos.controller;
import com.app.sos.model.User;
import com.app.sos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String salvarUser(@ModelAttribute("newUser" ) User user, Model model){
    //ModelAttribute -> pega o objeto do html, criado no getMapping cadastro e colocado no th:object

    model.addAttribute("mensagem", "Cadastro realizado!");
    //model.addAttribute -> adiciona a mensagem no template após usuário enviar
    userService.criarUser(user); //......método criado na classe "UserService" que enviará para o banco.
    return "/cadastro"; //.....redireciona para a página de cadastro.
    }

}