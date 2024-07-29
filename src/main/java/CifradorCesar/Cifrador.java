
package CifradorCesar;

import java.util.Scanner;

/**
 *
 * @author jhonny
 */
public class Cifrador {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------------");

        System.out.println("Digite a mensagem a ser criptografada: ");
        String mensagem = scanner.nextLine().toLowerCase();
        
        System.out.println("----------------------------------------------------");     
        
        System.out.println("Digite o deslocamento: ");
        int deslocamento = scanner.nextInt();
        System.out.println("----------------------------------------------------");
               
        System.out.println("Mensagem criptografada: " + encriptar(mensagem,deslocamento));
        
        System.out.println("----------------------------------------------------");

        System.out.println("Mensagem descriptografada: " + descriptografar(encriptar(mensagem,deslocamento),deslocamento));
        System.out.println("----------------------------------------------------");

        /* teste
        
            "A criptografia é essencial para a segurança das informações."
        
        */
        
    }
    
    private static String encriptar(String texto, int deslocamento){
        int tamanho = texto.length();
        StringBuilder textCifrado = new StringBuilder();
        char  caracter;
       
        for(int i = 0; i < tamanho; i++){
            caracter = texto.charAt(i);
            
            if(verificaCaracter(caracter)){
                textCifrado.append(caracter);
            }else{
                
                int letraAscii = ((int) caracter + (deslocamento));
            
                while(letraAscii >122){
                letraAscii -=26;
                }
                textCifrado.append((char) letraAscii);
            }
        }
        
        return textCifrado.toString();
    }
    
    private static String descriptografar(String textoCript, int deslocamento){
        int tamanho = textoCript.length();
        StringBuilder textDesc = new StringBuilder();
        char caracter;
        for(int i = 0; i < tamanho; i++){
            caracter = textoCript.charAt(i);
            
            if(verificaCaracter(caracter)){
                textDesc.append(caracter);
            }else{
                
            
            int letraAscii = ((int) caracter - (deslocamento));
            
            while (letraAscii < 97) {
                letraAscii += 26;
            }
            textDesc.append((char) letraAscii);
        }
        }

        return textDesc.toString();
             
    }
    
    private static Boolean verificaCaracter(char caracter){
                  
        return !Character.UnicodeBlock.of(caracter).equals(Character.UnicodeBlock.BASIC_LATIN) || 
                Character.isWhitespace(caracter) || !Character.isLetter(caracter);
    }   
    
}
