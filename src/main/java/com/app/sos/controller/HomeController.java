package com.app.sos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
   @GetMapping("/")
   public ModelAndView link(){
      ModelAndView mv = new ModelAndView("index"); 
      return mv;
   }   

   @GetMapping("/login")
   public String login(Model model){
      return "login";
   }

   @GetMapping("/index")
   public String backIndex(Model model){
      return "index";
   }   

   @GetMapping("/home")
   public String home(Model model){
      return "home";
   }   
}
