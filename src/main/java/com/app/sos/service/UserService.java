package com.app.sos.service;

import com.app.sos.model.User;
import com.app.sos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;

   //...Este método salva os estudantes cadstrados no db................
   public User criarUser(User user){
      return userRepository.save(user);
      
   }

   //...Este método lista os usuários cadastrados................
   public List<User> findAllUsers(){
      return userRepository.findAll();
   }
}
