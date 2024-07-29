/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CifradorVigenere;

import java.util.Scanner;

/**
 *
 * @author jhonny
 */
public class CifradorVigenere {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------");

        System.out.println("Digite a mensagem a ser criptografada: ");
        String mensagem = scanner.nextLine().toLowerCase();
        System.out.println("Digite a chave: ");
        String chave = scanner.nextLine().toLowerCase();

        System.out.println("----------------------------------------------------");

        exibirMensagem(mensagem, chave);
        /* teste
        
            "A criptografia é essencial para a segurança das informações."
        
         */
    }

    public static void exibirMensagem(String mensagem, String chave) {

        System.out.println("Mensagem criptografada: " + encriptar(mensagem, chave));

        System.out.println("----------------------------------------------------");

        System.out.println("Mensagem descriptografada: " + descriptografar(encriptar(mensagem, chave), chave));
        System.out.println("----------------------------------------------------");

    }

    private static String encriptar(String mensagem, String chave) {
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder criptografar = new StringBuilder();
        char auxiliar;
        char caracter;
        int z = chave.length();
        int y = 0;
        for (int i = 0; i < mensagem.length(); i++) {
            caracter = mensagem.charAt(i);
            if (verificaCaracter(caracter)) {
                criptografar.append(caracter);
            } else {

                for (int ss = 0; ss < alfabeto.length(); ss++) {
                    auxiliar = alfabeto.charAt(ss);

                    if (chave.charAt(y) == auxiliar) {
                        y++;
                        if (z == y) {
                            y = 0;
                        }
                        caracter += ss;
                        while (caracter > 122) {
                            caracter -= 26;
                        }
                        ss = alfabeto.length();
                        criptografar.append(caracter);

                    }
                }
            }
        }
        return criptografar.toString();
    }

    private static String descriptografar(String mensagemCriptografada, String chave) {
        StringBuilder descriptografar = new StringBuilder();
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        char auxiliar;
        char caracter;
        int z = chave.length();
        int y = 0;
        for (int i = 0; i < mensagemCriptografada.length(); i++) {
            caracter = mensagemCriptografada.charAt(i);
            if (verificaCaracter(caracter)) {
                descriptografar.append(caracter);
            } else {

                for (int ss = 0; ss < alfabeto.length(); ss++) {
                    auxiliar = alfabeto.charAt(ss);

                    if (chave.charAt(y) == auxiliar) {
                        y++;
                        if (z == y) {
                            y = 0;
                        }
                        caracter -= ss;
                        while (caracter < 97) {
                            caracter += 26;
                        }
                        ss = alfabeto.length();
                        descriptografar.append(caracter);

                    }
                }
            }
        }
        return descriptografar.toString();
    }

    private static Boolean verificaCaracter(char caracter) {

        return !Character.UnicodeBlock.of(caracter).equals(Character.UnicodeBlock.BASIC_LATIN)
                || Character.isWhitespace(caracter) || !Character.isLetter(caracter);
    }
}
