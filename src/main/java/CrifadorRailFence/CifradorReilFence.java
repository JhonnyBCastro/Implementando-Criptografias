/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrifadorRailFence;

import java.util.Scanner;

/**
 *
 * @author jhonny
 */
public class CifradorReilFence {
    //Cifrador atraves do metodo RailFence

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------");

        System.out.println("Digite a mensagem a ser criptografada: ");
        String mensagem = scanner.nextLine();

        System.out.println("----------------------------------------------------");

        exibirMensagem(mensagem);
        /* texto teste
            -nao tinha medo o tal joao de santo cristo
            -todo dia ela faz sempre a mesma coisa
         */

    }

    public static void exibirMensagem(String mensagem) {

        String mensagemCriptografada;
        String mensagemDescriptografada;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantas colunas voce ira querer que a mensagem seja divida?");
        System.out.println("Digite 2 para duas colunas.");
        System.out.println("Digite 3 para duas colunas.");
        System.out.println("Ou digite a quantidae de colunas desejadas.");
        int colunas = scanner.nextInt();
        System.out.println("----------------------------------------------------");

        switch (colunas) {
            case 2:
                mensagemCriptografada = encriptarDuasColunas(mensagem);
                mensagemDescriptografada = descriptografarDuasColunas(mensagemCriptografada);
                break;

            case 3:
                mensagemCriptografada = encriptarTresColunas(mensagem);
                mensagemDescriptografada = descriptografarTresColunas(mensagemCriptografada);
                break;
            default:
                mensagemCriptografada = encriptar(mensagem, colunas);
                mensagemDescriptografada = desencriptar(mensagemCriptografada, colunas);
        }

        System.out.println("Mensagem criptografada: " + mensagemCriptografada);

        System.out.println("----------------------------------------------------");

        System.out.println("Mensagem descriptografada: " + mensagemDescriptografada);
        System.out.println("----------------------------------------------------");

    }

    private static String encriptarDuasColunas(String mensagem) {

        int tamanho = mensagem.length();
        StringBuilder parteUm = new StringBuilder();
        StringBuilder parteDois = new StringBuilder();
        char caracter;
        StringBuilder mensagemCrip = new StringBuilder();
        int x = 0;

        for (int i = 0; i < tamanho; i++) {
            caracter = mensagem.charAt(i);

            if (!Character.isWhitespace(caracter)) {
                if (x == 0) {
                    parteUm.append(caracter);
                    x++;
                } else {
                    parteDois.append(caracter);
                    x--;
                }
            }
        }

        System.out.println("String 1: " + parteUm);
        System.out.println("String 2: " + parteDois);
        mensagemCrip.append(parteUm);
        mensagemCrip.append(parteDois);

        return addEspaco(mensagem, mensagemCrip);
    }

    private static String descriptografarDuasColunas(String mensagemCriptografada) {
        int tamanho = mensagemCriptografada.length();
        char caracter;
        int x = 0, y = 0, z = 0;
        int tamanhoTexto;
        StringBuilder texto = new StringBuilder();
        StringBuilder mensagemDescriptografada = new StringBuilder();
        String substring1;
        String substring2;

        for (int i = 0; i < tamanho; i++) {
            caracter = mensagemCriptografada.charAt(i);
            if (!Character.isWhitespace(caracter)) {
                texto.append(caracter);
            }
        }
        tamanhoTexto = texto.length();

        if (tamanhoTexto % 2 == 0) {
            substring1 = texto.substring(0, tamanhoTexto / 2);
        } else {
            substring1 = texto.substring(0, tamanhoTexto / 2 + 1);
        }

        substring2 = texto.substring(substring1.length(), tamanhoTexto);

        for (int i = 0; i < texto.length(); i++) {
            if (x == 0) {
                char caracterUm = substring1.charAt(y);
                if (!Character.isWhitespace(caracterUm)) {
                    mensagemDescriptografada.append(caracterUm);
                    x++;
                }
                y++;
            } else {
                char caracterDois = substring2.charAt(z);
                if (!Character.isWhitespace(caracterDois)) {
                    mensagemDescriptografada.append(caracterDois);
                    x--;
                }
                z++;
            }

        }

        return addEspaco(mensagemCriptografada, mensagemDescriptografada);
    }

    private static String encriptarTresColunas(String mensagem) {

        int tamanho = mensagem.length();
        StringBuilder parteUm = new StringBuilder();
        StringBuilder parteDois = new StringBuilder();
        StringBuilder parteTres = new StringBuilder();
        char caracter;
        StringBuilder mensagemCrip = new StringBuilder();
        int x = 0;

        for (int i = 0; i < tamanho; i++) {
            caracter = mensagem.charAt(i);

            if (!Character.isWhitespace(caracter)) {
                switch (x) {
                    case 0:
                        parteUm.append(caracter);
                        x++;
                        break;
                    case 1:
                        parteDois.append(caracter);
                        x++;
                        break;
                    default:
                        parteTres.append(caracter);
                        x = 0;
                        break;
                }
            }
        }

        System.out.println("String 1: " + parteUm);
        System.out.println("String 2: " + parteDois);
        System.out.println("String 3: " + parteTres);
        mensagemCrip.append(parteUm);
        mensagemCrip.append(parteDois);
        mensagemCrip.append(parteTres);

        return addEspaco(mensagem, mensagemCrip);
    }

    private static String descriptografarTresColunas(String mensagemCriptografada) {
        int tamanho = mensagemCriptografada.length();
        char caracter;
        int x = 0, y = 0, z = 0, w = 0;
        int tamanhoTexto;
        StringBuilder texto = new StringBuilder();
        StringBuilder mensagemDescriptografada = new StringBuilder();
        String substring1;
        String substring2;
        String substring3;
        String auxiliar;

        for (int i = 0; i < tamanho; i++) {
            caracter = mensagemCriptografada.charAt(i);
            if (!Character.isWhitespace(caracter)) {
                texto.append(caracter);
            }
        }
        tamanhoTexto = texto.length();

        if (tamanhoTexto % 3 == 0) {
            substring1 = texto.substring(0, tamanhoTexto / 3);
            substring2 = texto.substring((tamanhoTexto / 3), tamanhoTexto - substring1.length());
            substring3 = texto.substring((tamanhoTexto / 3) + substring2.length(), tamanhoTexto);

        } else {
            substring1 = texto.substring(0, tamanhoTexto / 3 + 1);
            auxiliar = texto.substring(substring1.length(), tamanhoTexto);
            if ((auxiliar.length() % 2 == 0)) {
                substring2 = auxiliar.substring(0, auxiliar.length() / 2);
                substring3 = auxiliar.substring(substring2.length(), auxiliar.length());
            } else {
                substring2 = auxiliar.substring(0, auxiliar.length() / 2 + 1);
                substring3 = auxiliar.substring(substring2.length(), auxiliar.length());
            }
        }

        for (int i = 0; i < texto.length(); i++) {
            switch (x) {
                case 0:
                    char caracterUm = substring1.charAt(y);
                    if (!Character.isWhitespace(caracterUm)) {
                        mensagemDescriptografada.append(caracterUm);
                        x++;
                    }
                    y++;
                    break;
                case 1:
                    char caracterDois = substring2.charAt(z);
                    if (!Character.isWhitespace(caracterDois)) {
                        mensagemDescriptografada.append(caracterDois);
                        x++;
                    }
                    z++;
                    break;
                default:
                    char caracterTres = substring3.charAt(w);
                    if (!Character.isWhitespace(caracterTres)) {
                        mensagemDescriptografada.append(caracterTres);
                        x = 0;
                    }
                    w++;
                    break;
            }
        }

        return addEspaco(mensagemCriptografada, mensagemDescriptografada);
    }

    private static String addEspaco(String mensagem, StringBuilder mensagemSemEspaco) {

        int tamanho = mensagem.length();
        char caracter;
        char caracterCriptografado;
        StringBuilder texto = new StringBuilder();
        String textoCripto = mensagemSemEspaco.toString();
        int j = 0;

        for (int i = 0; i < tamanho; i++) {
            caracter = mensagem.charAt(i);
            if (Character.isWhitespace(caracter)) {
                texto.append(caracter);
            } else {
                caracterCriptografado = textoCripto.charAt(j++);
                texto.append(caracterCriptografado);
            }

        }

        return texto.toString();
    }

    private static String encriptar(String mensagem, int divisoes) {
        String[] texto = new String[divisoes];
        char caracter;
        StringBuilder stringBuilder = new StringBuilder();
        int j = 0;
        /*
            ola mundo novo que requer muita atencao nos dias atuais
         */

        for (int i = 0; i < mensagem.length(); i++) {
            caracter = mensagem.charAt(i);
            if (!Character.isWhitespace(caracter)) {

                if (j == divisoes) {
                    j = 0;
                }

                StringBuilder sb = new StringBuilder();
                String auxiliar;
                if (texto[j] != null) {
                    auxiliar = texto[j];
                    sb.append(auxiliar);
                }
                sb.append(caracter);

                texto[j] = sb.toString();

                j++;
            }
        }

        for (int k = 0; k < divisoes; k++) {
            String s;
            s = texto[k];
            stringBuilder.append(s);

        }

        return addEspaco(mensagem, stringBuilder);
    }

    private static String desencriptar(String mensagemCripto, int divisoes) {
        char caracter;
        StringBuilder texto = new StringBuilder();
        StringBuilder mensagemDescriptografada = new StringBuilder();
        String[] arrayStrings = new String[divisoes];
        String auxiliar = null;

        /* texto teste
            A criptografia é essencial para a segurança das informações.
         */

        for (int i = 0; i < mensagemCripto.length(); i++) {
            caracter = mensagemCripto.charAt(i);
            if (!Character.isWhitespace(caracter)) {
                texto.append(caracter);
                auxiliar = texto.toString();
            }
        }
        int div = divisoes;

        for (int j = 0; j < divisoes; j++) {
            if (texto.length() % div == 0) {
                arrayStrings[j] = texto.substring(0, texto.length() / div);
                texto.delete(0, texto.length() / div);
                div--;
            } else {
                arrayStrings[j] = texto.substring(0, texto.length() / div + 1);
                texto.delete(0, texto.length() / div + 1);
                div--;
            }
        }

        int l = 0;
        int m = 0;
        for (int k = 0; k < auxiliar.length(); k++) {
            String s;
            s = arrayStrings[l];

            caracter = s.charAt(m);
            l++;
            if (l == divisoes) {
                l = 0;
                m++;
            }

            mensagemDescriptografada.append(caracter);
        }

        return addEspaco(mensagemCripto, mensagemDescriptografada);
    }

}
