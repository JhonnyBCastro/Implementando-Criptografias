# Implementando Criptografias Clássicas

Este repositório contém implementações de três algoritmos clássicos de criptografia: **Cifra de César**, **Cifra de Vigenère** e **Cifra Rail Fence**.

## Cifra de César

A Cifra de César é uma das técnicas de criptografia mais simples e conhecidas. É um tipo de cifra de substituição em que cada letra do texto é deslocada um número fixo de posições no alfabeto.

### Implementação

A implementação em Java permite criptografar e descriptografar uma mensagem fornecida pelo usuário. O usuário também especifica o deslocamento (número de posições a serem deslocadas). 

1. **A função `encriptar`**: pecorre cada caracter da mensagem e aplica o deslocamento especificado utilizando os valores da tabela ASCII, sendo os valores pré definidos que vão de 97<>122(respectivos aos caracteres minusculos).

2. **A função `verificaCaracter`**: é utilizada para que apenas caracteres validos do alfabeto sofram o deslocamento.

3. **A função `descriptografar`**: pecorre cada caracter da mensagem criptografada e reverte o deslocamneto utilizando como base a tabela ASCII.

##

  ## Cifra de Vigenère
  
A Cifra de Vigenère é um método de criptografia por substituição polialfabética que utiliza uma palavra-chave para determinar o deslocamento das letras na mensagem original. Cada letra da palavra-chave corresponde a um deslocamento específico, que é aplicado ciclicamente ao texto.

###Implementação

A implementação em Java permite criptografar e descriptografar uma mensagem fornecida pelo usuário utilizando uma chave que tambem foi fornecida.

1. **Definição do alfabeto**: O alfabeto foi definido explicitamente para realizar a busca de caracteres.
2. **Busca da palavra-chave**: Cada caractere da palavra-chave é comparado ao alfabeto para determinar o deslocamento.
3. **Deslocamento de caracteres**: O valor do deslocamento é somado ao valor ASCII do caractere da mensagem. Se o valor resultante exceder 'z', ele é ajustado para voltar ao início do alfabeto.

  ## Cifra de Rail Fence

A Cifra de Rail Fence é um método de transposição que organiza a mensagem em um padrão de "zig-zag" em várias "colunas" (ou "rails") e depois lê a mensagem linha por linha.

### Implementação

A implementação em Java permite criptografar e descriptografar uma mensagem fornecida pelo usuário, utilizando um número especificado de colunas (ou "rails").

#### Encriptação

As funções `encriptarTresColunas` e `encriptarDuasColunas` são exemplos de como seria feita a divisão em colunas que foram pré-estabelecidas. E as funções `descriptografarTresColunas` e `descriptografarDuasColunas` mostram como seria feita a separação das Strings nas colunas para que possa haver a descriptografia.

A função `encriptar` organiza a mensagem em várias colunas de acordo com o desejado e depois concatena as colunas para formar a mensagem criptografada.

1. **Entrada do usuário**: O usuário fornece a mensagem e o número de colunas desejado.
2. **Organização em colunas**: A mensagem é dividida em colunas alternadas, ignorando espaços.
3. **Concatenação das colunas**: As colunas são concatenadas para formar a mensagem criptografada.

A função `desencriptar` reverte o processo de encriptação ao reorganizar a mensagem criptografada em suas colunas originais e ler as colunas em ordem para formar a mensagem original.

1. **Divisão em colunas**: A mensagem criptografada é dividida nas colunas originais.
2. **Reorganização em ordem original**: As colunas são lidas em ordem para reconstruir a mensagem original.
