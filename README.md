# Implementando Criptografias Clássicas

Este repositório contém implementações de três algoritmos clássicos de criptografia: **Cifra de César**, **Cifra de Vigenère** e **Cifra Rail Fence**.

## Cifra de César

A Cifra de César é uma das técnicas de criptografia mais simples e conhecidas. É um tipo de cifra de substituição em que cada letra do texto é deslocada um número fixo de posições no alfabeto.

### Implementação

A implementação em Java permite criptografar e descriptografar uma mensagem fornecida pelo usuário. O usuário também especifica o deslocamento (número de posições a serem deslocadas). 
>  1-A função `encriptar` pecorre cada caracter da mensagem e aplica o deslocamento especificado utilizando os valores da tabela ASCII, sendo os valores pré definidos que vão de 97<>122(respectivos aos caracteres minusculos).
>  2-A função `verificaCaracter` é utilizada para que apenas caracteres validos do alfabeto sofram com deslocamento. 
>  3- A função `descriptografar` pecorre cada caracter da mensagem criptografada e reverte o deslocamneto utilizando como base a tabela ASCII.

  ## Cifra de Vigenère
