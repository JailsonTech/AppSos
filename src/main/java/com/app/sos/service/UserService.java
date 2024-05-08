package com.app.sos.service;

import com.app.sos.exception.UserNotFoundException;
import com.app.sos.model.User;
import com.app.sos.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;

   //...SALVAR USUÁRIOS NO DB................
   public User criarUser(User user) {
      return userRepository.save(user);
   }

   //...BUSCAR TODOS USUÁRIOS CADASTRADOS...............
   public List<User> findAllUsers() {
      return userRepository.findAll();
   }

   //.......APAGANDO USUÁRIOS DO DB.........................

   //...BUSCANDO USUÁRIO PELO ID...........
   public User buscarIdUser(Long id) throws UserNotFoundException {
      Optional<User> opt = userRepository.findById(id);
      if (opt.isPresent()) { //...Poderia ser a seguinte expressão... -> return opt.orElse(null);
         return opt.get();
      } else {
         throw new UserNotFoundException("Usuário com id: " + id + " não existe");
      }
   }

   //.....DELETANDO USUÁRIO.............
   public void apagaUser(Long id) throws UserNotFoundException {
      User user = buscarIdUser(id);
      userRepository.delete(user);
   }

   //...ATUALIZANDO ID DA TABELA PARA REINICIAR COM 1.........
   @PersistenceContext
   private EntityManager entityManager;

   // Outros métodos do serviço...

   @Autowired
   private DataSource dataSource;

   // Outros métodos do serviço...

   public void resetIdSequence() {
      try (Connection connection = dataSource.getConnection();
           Statement statement = connection.createStatement()) {
         statement.execute("ALTER TABLE tb_users ALTER COLUMN id RESTART WITH 1");
      } catch (
            SQLException e) {
         e.printStackTrace(); // Trate ou registre o erro conforme necessário
      }
   }
}
