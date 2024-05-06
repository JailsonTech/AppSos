
function calcularIMC(peso, altura) {
// Recebendo entrada do usuário no html
peso = parseFloat(document.getElementById('weight').value);
altura = parseFloat(document.getElementById('height').value);

// Verificar se os valores inseridos são válidos
    if (isNaN(peso) || isNaN(altura) || peso <= 0 || altura <= 0) {
        alert('Por favor, insira valores válidos para peso e altura.');
        return;
    }

// Calculando o IMC
imc = peso / Math.pow(altura, 2);

//saída do resultado no <h3>
 document.getElementById('saida1').textContent = 'Seu IMC é: ' + imc.toFixed(2);

var resultado;
var cor;
var fundo;

if (imc < 18.5) {
    fundo = "#f3ff85";
    cor = "#000000";
    resultado = 'Abaixo do peso';
} else if (imc < 25) {  
    fundo = "#5ee651";
    cor = "#fff";  
    resultado = 'Peso normal';
} else if (imc < 30) {
    fundo ="#952eda";;
    cor = "#dfff29"; 
    resultado = 'Sobrepeso';
} else {
    fundo = "#da0c0c";
    cor = "#ffffff";
    resultado = 'Obesidade';
}

// Atualizar estilos CSS do elemento
var saida2 = document.getElementById('saida2');
saida2.textContent = 'Classificação: ' + resultado;
saida2.style.backgroundColor = fundo;
saida2.style.color = cor;
}

function limparCampos() {
    document.getElementById('weight').value = '';
    document.getElementById('height').value = '';
    document.getElementById('saida1').textContent = '';
    document.getElementById('saida2').textContent = '';
    saida2.style.backgroundColor="";

}