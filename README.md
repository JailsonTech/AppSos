**APP PRIMEIROS SOCORROS**<br>
EXECUÇÃO DE TESTES UNITÁRIOS E INTEGRAÇÃO<br>
CONFIGURAÇÃO GIT FLOW E GIT ACION

......CONFIGURAÇÃO DO CONTROLLER........

@GetMapping("/cadastro")

public String newUser(Model model) {

User user = new User(); 

}

-> criado objeto "user"
model.addAttribute("newUser", user);

-> "newUser" será o "object" do formulário
return "/cadastro";
.........................................

SALVAR USUÁRIOS NO BANCO

@PostMapping("/salvar")
public String salvarUser(Model model, @ModelAttribute("newUser") @Valid User user,  BindingResult erros, RedirectAttributes attributes) {

-> validação dos erros, anexação dos erros em 'erros', redirecionado para 'attributes'

.........................................

if (erros.hasErrors()) {
return "/cadastro";
}

-> condição para execução dos erros

.........................................

model.addAttribute("mensagem", "Cadastro realizado!")

-> adiciona a mensagem no template após usuário enviar

.........................................

userService.criarUser(user);

-> useService enviará para o db.

.........................................

return "/cadastro";}

-> redireciona para cadastro.html.




    }
}