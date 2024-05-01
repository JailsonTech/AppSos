package com.app.sos.repositories;

import com.app.sos.controller.UserController;
import com.app.sos.entities.Imc;
import com.app.sos.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    static void save(Imc imc) {
    }

    static void save(UserController.Calculo calculo) {
    }
}
