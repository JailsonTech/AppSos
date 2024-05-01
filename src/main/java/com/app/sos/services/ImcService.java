package com.app.sos.services;

import com.app.sos.entities.Imc;
import com.app.sos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ImcService {

    @Autowired
    private UserRepository repository;

    public double realizarCalculo(double peso, double altura) {
        double resultado = peso / (altura*altura); // Calculo imc

        Imc calculo = new Imc();
        calculo.setPeso(peso);
        calculo.setAltura(altura);
        calculo.setResultado(resultado);
        UserRepository.save(calculo);
        return resultado;

    }
}
