package com.app.sos.repository;

import com.app.sos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   @Modifying
   @Query(nativeQuery = true, value = "ALTER SEQUENCE user_id_seq RESTART WITH 1")
      // Substitua 'user_id_seq' com o nome da sua sequência
   void resetIdSequence();
}

