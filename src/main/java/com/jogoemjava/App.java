package com.jogoemjava;

import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("O número aleatorio é: " + rand.nextInt(100));
        System.out.println("Digite seu primeiro nome:");
        String nome = in.nextLine();

        //Variáveis
        int vida = 26;
        String frase = "Olá mundão!";
        boolean var = true;
        char letra = 'a';
        double numeroDecimal = 21.9;

        //Constantes
        final int vidaMaxima = 10;

        //Arrays Normal
        String[] nomeArray = new String[3];
        nomeArray[0] = "Paulo";
        nomeArray[1] = "Henrique";

        //Array MultiDimensional
        String[][]  nomeMultiDimensional = new String[3][3];
        nomeMultiDimensional[0][0] = nome;
        nomeMultiDimensional[0][1] = "Bezos";

        System.out.println("Nome: "+nomeMultiDimensional[0][0]+" "+nomeMultiDimensional[0][1]);
         vida = 100;
         if (vida > 100){vida += 100;System.out.println("Vida: "+vida+" (Sua vida é maior do que 100)");
         }else if(vida == 100) {System.out.println("Vida: "+vida+" (Sua vida é igual a 100)");
         }else{System.out.println("Vida: "+vida+" (Sua vida é abaixo de 100)");
         }

         String classe = "guerreiro";
         switch(classe){
             case "guerreiro":
                 System.out.println("Arma: Espada");
                 break;
             case "mago":
                 System.out.println("Arma: Cajado");
                 break;
             case "arqueiro":
                 System.out.println("Arma: Arco e Flecha");
         }

         final int vidaMinima = 0;
         boolean temSkillDeReviver = true;
         if (vida <= vidaMinima || temSkillDeReviver == false){
             System.out.println("Game Over");
         }

         /*
         int contador = 0;
         while(contador <= 10){
             System.out.println("Olá, agora o contador está em: "+contador);
             contador++;
         }*/


        for (int cont = 0; cont <=3;cont++){
            System.out.println("Oi, agora o contador está na casa: "+(cont));
        }

        /*
        int contad =0;
        do{
            System.out.println(contad);
            contad++;
        }while(contad <10);
        */
    }
}
