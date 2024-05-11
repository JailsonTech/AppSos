package com.app.sos.controller;

import com.app.sos.exception.UserNotFoundException;
import com.app.sos.model.User;
import com.app.sos.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

   @Autowired
   private UserService userService;

   //......ACESSAR AS PÁGINAS HTML ATRAVÉS DE LINKS OU NO..............

   @GetMapping("/")
   public String pagIndex() {
      return "index";
   }

   @GetMapping("/login")
   public String pagLogin() {
      return "login";
   }

   @GetMapping("/home")
   public String pagHome() {
      return "home";
   }

   @GetMapping("/imc")
   public String pagImc() {
      return "imc";
   }

   @GetMapping("/resultado")
   public String pagResultado() {
      return "resultadoImc";
   }

   //........PERSISTÊNCIA DE DADOS............
   @GetMapping("/cadastro")
   public String newUser(Model model) {   //......método model do spring
      User user = new User();   //......criado objeto "user"
      model.addAttribute("newUser", user);//......"newUser" será o "object" do formulário
      return "/cadastro";
   }

   //........SALVAR USUÁRIOS NO BANCO
   @PostMapping("/salvar")
   public String salvarUser(Model model, @ModelAttribute("newUser") @Valid User user, BindingResult erros, RedirectAttributes attributes) {

      if (erros.hasErrors()) {
          
         return "/cadastro";
      }
      model.addAttribute("mensagem", "Cadastro realizado!"); //...Mensagem de sucesso no cadastro.html
      userService.criarUser(user);
      return "/cadastro";
   }

   //........RETORNO DE DADOS.................
   @GetMapping("/lista")
   public String paglistUsers(Model model) {
      List<User> user = userService.findAllUsers();
      //... O objeto, "users", será¡ colocado na tabela em "listUsers.html" em th:each="user ${}" e em cada <td th:text="${user.id}"></td>
      model.addAttribute("listUsers", user);
      //... O atributo, "listUsers", será colocado na tabela html em ${listUsers}

      return "listUsers";
   }

   //........APAGAR DADOS.....................
   @GetMapping("/apagar/{id}")
   public String apagarUser(Model model, @PathVariable("id") long id) {
      try {
         userService.apagaUser(id);
      } catch (
              UserNotFoundException e) {
         model.addAttribute("messageError", e.getMessage());
      }
      
      return "redirect:/lista";
   }

   //...........EDITAR USUÁRIOS..............
   @GetMapping("/editar/{id}")
   public String editarForm(Model model, @PathVariable("id") long id, RedirectAttributes attributes) {
      try { // abre a página de edição do banco de dados...editUsers.html
         User user = userService.buscarIdUser(id);
         model.addAttribute("editaUser", user);
         return "/editUsers";
      } catch (
              UserNotFoundException e) {
         model.addAttribute("messageError", e.getMessage());
      }
      return "redirect:/lista";
   }

   //........ENVIAR USUÁRIOS EDITADOS PARA O DB...........
   @PostMapping("/editar/{id}")
   public String editaUser(Model model, @PathVariable("id") long id, @ModelAttribute("editaUser") @Valid User user, BindingResult erros) {
      if (erros.hasErrors()) {
         return "/editar";
      }

      userService.editUser(user);
      return "redirect:/lista";
   }

}
