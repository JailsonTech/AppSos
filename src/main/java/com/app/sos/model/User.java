package com.app.sos.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", length=100, nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    @Size(min=4, message="Mínimo de 4 letras exigido")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Inválido, evite números ou caracteres.")
    private String nome;

    @Column(name="email", length=180, nullable = false)
    @Email(message = "O email deve ser válido")
    @NotBlank(message="O email é obrigatório")
    @Pattern(regexp = ".*@(gmail\\.com|hotmail\\.com|outlook\\.com)$", message = "exemplo: abc@gmail.com / abc@hotmail.com etc...")
    private String email;

    @Column(name="senha", length=5, nullable = false)
    @Pattern(regexp = "^[0-9]{5}$", message = "Máx 5 números aleatórios.")
    @NotBlank(message="A senha não pode ser em branco")
    private String senha;

    public User(){  }  //.....CONSTRUTOR SEM ARGUMENTOS

//.......GETTER & SETTER................

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

}
