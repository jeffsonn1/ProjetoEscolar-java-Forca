package forca;
import java.util.Random;
import java.util.Scanner;
public class Forca {
    public static void main(String[] args) {
        //importações
        Random rd = new Random();
        Scanner tcl = new Scanner(System.in);
        
        //sorteando as palavras
        String  palavras[] = {"PAPEL", "SAPATO", "ZEBRA", "ADESIVO", "LUPA", "TECLADO", "CARRO", "ACENDER", "AFILHADO", "ARDILOSO",
        "ASTERISCO", "CHUVEIRO", "CONTEXTO", "ESFIRRA", "ESQUERDA", "IMPACTO", "POVO", "ANIMADO"};
        int quatidpala = palavras.length;
        int isorte = rd.nextInt(quatidpala);
        String sorte = palavras[isorte];
        
        //variaveis
        char letra, letram;
        String letracom, utilizadas = "";
        boolean vitoria = false, semchance;
        int chance = 5, rodada = 1;
        
        
        /*iniciando a char casos
        ex de como vai ser a ideia:
             P | A | P | E | L 
             0   1   2   3   4
            - passando pela char -
             _ | _ | _ | _ | _ 
             0   1   2   3   4
            - preechendo com alguma letra P -
             P | _ | P | _ | _
             0   1   2   3   4
            
        */
        String[] casos = new String[palavras.length];
        for (int i = 0; i < sorte.length(); i++) {
            casos[i]=" __ ";
        }
        
        //mostrador de início
        for (int i = 0; i < sorte.length(); i++) {
            System.out.print(casos[i]);
        }
        
        
        
        //laço
        while(chance > 0 && !vitoria) {
        vitoria = true;
        semchance = true;
        //menu
        System.out.println("\n **** RODADA - " + rodada + " ****");
        System.out.println(" Você tem " + chance + " chances");
        System.out.println(" Já utilizou as letras" + utilizadas);
        System.out.print(" Escolha alguma letra: ");
        letra = tcl.next().charAt(0);
        letram = Character.toUpperCase(letra);
        utilizadas += " - " + letram;
        
        //checagem de letra
        for (int i = 0; i < sorte.length(); i++) {
            if (letram==sorte.charAt(i)) { 
                letracom = Character.toString(letram);
                casos[i]=letracom;
                semchance = false;
                
            }
        }
        
        
        //substituidor
        for (int i = 0; i < sorte.length(); i++) {
            if (!(casos[i].equals(" __ "))) {
             System.out.print(" " + sorte.charAt(i) + " ");
            } else {
             System.out.print(casos[i]);
             vitoria = false;
            }
        }
        
        //checa as vidas
        if (semchance) {
            chance--;
        }
        
        System.out.println("\n\n");
        rodada++;
        }
        
        
        //mensagens de vitoria - derrota
        if (chance > 0) {
        System.out.print("****Jogo finalizado. Parabéns!!!!****");
        } else {
        System.out.print("****Infelizmento você perdeu****");
        }
    }
    
}
