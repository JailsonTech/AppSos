function limparCampos() {
            // Limpa o valor dos campos do formulário após o envio
            document.getElementById("nome").value = "";
            document.getElementById("email").value = "";
            document.getElementById("password").value = "";
            var mensagemElement = document.getElementById("alerta");
            setTimeout(function() {
                mensagemElement.style.display = "none";
            }, 5000); // 5000 milissegundos = 5 segundos
        }