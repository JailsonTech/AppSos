function calcularIMC(peso, altura) {
// Recebendo entrada do usuário no html
peso = parseFloat(document.getElementById('weight').value);
altura = parseFloat(document.getElementById('height').value);

// Verificando se as entradas são válidas
if (peso =="" || altura=="" || peso<0 || altura<0) {
    alert("Por favor, insira valores numéricos válidos.");
}

    // Calculando o IMC
    resultado = peso / Math.pow(altura, 2);

   // saída no html
    document.getElementById('saida1').innerHTML = "Seu Imc é: " + resultado.toFixed(2);

if (resultado < 18.5) {
        background.style.backgroundColor = "#f3ff85";
        color.style.color = "#000000";
        return situacao.innerHTML = "Situação: MAGREZA";  

    } else if (resultado >= 18.5 && resultado < 25) {
        background.style.backgroundColor= "#5ee651";
        color.style.color= "#fff";
        return situacao.innerHTML = "Situação: NORMAL";  

    } else if (resultado >= 25 && resultado < 30) {
        background.style.backgroundColor= "#952eda";
        color.style.color= "#dfff29";
        return situacao.innerHTML= "Situação: SOBREPESO"; 

    } else{
        background.style.backgroundColor = "#da0c0c";
        color.style.color= "#ffffff";
        return situacao.innerHTML = "Situação: OBESIDADE";  
    }  

}

function limparCampos() {
    document.getElementById('weight').value = '';
    document.getElementById('height').value = '';
    document.getElementById('saida1').innerHTML = '';
    document.getElementById('saida2').innerHTML = '';
    }