
// Limpa a mensagem após 6 segundos
    const tymeOut = setTimeout(limparCampos, 3000);

function limparCampos() {
    // Limpa o valor dos campos do formulário
    document.getElementById('alerta').innerHTML = '';
    document.getElementById("nome").value = "";
    document.getElementById("email").value = "";
    document.getElementById("password").value = "";
}

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
