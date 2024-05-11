
//LIMPAR OS INPUTS DO CADASTRO

// Limpa a mensagem após 6 segundos
    const tymeOut = setTimeout(limparCampos, 2000);

function limparCampos() {
    // Limpa o valor dos campos do formulário
    document.getElementById('alerta').innerHTML = '';
    document.getElementById("nome").value = "";
    document.getElementById("email").value = "";
    document.getElementById("password").value = "";
    document.getElementById("alerta").style.border= "none";

}

//...MUDAR A COR DO TEXTO -> "sair"........
function mudaCor() {
  var x = document.getElementById("myDIV");
  if (x.innerHTML === "Hello") {
    x.innerHTML = "Swapped text!";
  } else {
    x.innerHTML = "Hello";
  }
} 

//...MOSTRAR E ESCONDER A BARRA DE MENU - DROPDOWN

document.addEventListener('DOMContentLoaded', function() {
    var dropdownTrigger = document.getElementById('dropdown-trigger');
    var barTrigger = document.getElementById('bar-trigger');

    barTrigger.addEventListener('click', function(event) {
        event.stopPropagation();
        dropdownTrigger.classList.toggle('active');
    });

    document.addEventListener('click', function(event) {
        dropdownTrigger.classList.remove('active');
    });

    dropdownTrigger.addEventListener('click', function(event) {
        event.stopPropagation();
    });
});

// Função para fechar o dropdown ao sair da página
function fecharDropdown() {
    // Recolher o dropdown
    var dropdown = document.getElementById('dropdown-trigger');
    dropdown.style.display = 'none';
}

// Adiciona um ouvinte de evento que escuta quando o usuário está saindo da página
window.addEventListener('beforeunload', fecharDropdown);


// Função para exibir a caixa de diálogo de confirmação no editUsers.html
function confirmarExclusao(event) {
    // Previne o envio do formulário até que a confirmação seja feita
    event.preventDefault();
    
    // Exibe a caixa de diálogo de confirmação
    if (confirm("Tem certeza que deseja editar os dados?")) {
        // Se o usuário clicar em "OK", envia o formulário de exclusão
        document.getElementById("editId").submit();
    } else {
        // Se o usuário clicar em "Cancelar", não faz nada
        return false;
    }
}

// CONFIRMAÇÃO DE EDIÇÃO PARA O FORMULÁRIO editUsers.html
function confirmarEdicao(event) {
    // Previne o envio do formulário até que a edição seja feita
    event.preventDefault();
    
    // Exibe a caixa de diálogo de confirmação
    if (confirm("Confirme a edição dos dados?")) {
        // Se o usuário clicar em "OK", envia o formulário editado
        document.getElementById("editId").submit();
    } else {
        // Se o usuário clicar em "Cancelar", não faz nada
        return false;
    }
}



