# Implementando Criptografias Clássicas

Este repositório contém implementações de três algoritmos clássicos de criptografia: **Cifra de César**, **Cifra de Vigenère** e **Cifra Rail Fence**.

## Cifra de César

A Cifra de César é uma das técnicas de criptografia mais simples e conhecidas. É um tipo de cifra de substituição em que cada letra do texto é deslocada um número fixo de posições no alfabeto.

### Implementação

A implementação em Java permite criptografar e descriptografar uma mensagem fornecida pelo usuário. O usuário também especifica o deslocamento (número de posições a serem deslocadas). 

> 1-A função `encriptar` pecorre cada caracter da mensagem e aplica o deslocamento especificado utilizando os valores da tabela ASCII, sendo os valores pré definidos que vão de 97<>122(respectivos aos caracteres minusculos).

> 2-A função `verificaCaracter` é utilizada para que apenas caracteres validos do alfabeto sofram o deslocamento.

> 3- A função `descriptografar` pecorre cada caracter da mensagem criptografada e reverte o deslocamneto utilizando como base a tabela ASCII.

##

  ## Cifra de Vigenère
  
A Cifra de Vigenère é um método de criptografia por substituição polialfabética que utiliza uma palavra-chave para determinar o deslocamento das letras na mensagem original. Cada letra da palavra-chave corresponde a um deslocamento específico, que é aplicado ciclicamente ao texto.

###Implementação

A implementação em Java permite criptografar e descriptografar uma mensagem fornecida pelo usuário utilizando uma chave que tambem foi fornecida.

> 1-Na função `encriptar` o alfabeto foi definido, pois é através dele que iremos realizar a busca e pegar o indice dele
