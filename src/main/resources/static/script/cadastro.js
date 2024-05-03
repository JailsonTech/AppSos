
// Limpa a mensagem após 6 segundos
    const tymeOut = setTimeout(limparCampos, 4000);

function limparCampos() {
    // Limpa o valor dos campos do formulário
    document.getElementById('alerta').innerHTML = '';
    document.getElementById("nome").value = "";
    document.getElementById("email").value = "";
    document.getElementById("password").value = "";    
}

