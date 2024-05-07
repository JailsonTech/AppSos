
// Limpa a mensagem após 6 segundos
    const tymeOut = setTimeout(limparCampos, 6000);

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
