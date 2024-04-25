package com.app.sos.models;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Long id;
@Column(name="nome", length=100, nullable = false)
private String nome;

@Column(name="email", length=180, nullable = false)
private String email;

@Column(name="senha", length=15, nullable = false)
private String senha;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
