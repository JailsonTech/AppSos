package com.app.sos.service;

import com.app.sos.exception.UserNotFoundException;
import com.app.sos.model.User;
import com.app.sos.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;


//............................................................

   //...BUSCAR TODOS USUÁRIOS CADASTRADOS...............
   public List<User> findAllUsers() {
      return userRepository.findAll();
   }

   //...BUSCANDO USUÁRIO PELO ID...........
   public User buscarIdUser(Long id) throws UserNotFoundException {
      Optional<User> opt = userRepository.findById(id);
      if (opt.isPresent()) {
         //...Poderia ser a seguinte expressão... -> return opt.orElse(null);
         return opt.get();
      } else {
         throw new UserNotFoundException("Usuário com id: " + id + " não existe");
      }
   }

   //...CRIAR USUÁRIOS................
   public User criarUser(User user) {
      return userRepository.save(user);
   }

   //.....APAGAR USUÁRIOS.............
   public void apagaUser(Long id) throws UserNotFoundException {
      User user = buscarIdUser(id);
      userRepository.delete(user);
   }

   //...EDITAR USUÁRIOS................
   public User editUser(User user) {
      //deve ser chamado no controller no editar
      return userRepository.save(user);
   }
}
