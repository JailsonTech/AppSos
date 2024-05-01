package com.app.sos.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_users")
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", length=100, nullable = false)
    private String nome;

    @Column(name="email", length=180, nullable = false)
    private String email;

    @Column(name="senha", length=15, nullable = false)
    private String senha;

//..........CHAVE ESTRANGEIRA - Imc (entidade)................
@OneToOne
@JoinColumn(name = "Imc_id")
private Imc imc;

//.......CONSTRUTOR SEM ARGUMENTOS........

    public Users(){

    }
//.......GETTER & SETTER................

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
