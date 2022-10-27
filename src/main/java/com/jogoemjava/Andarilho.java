package com.jogoemjava;

import java.util.Scanner;

public class Andarilho
{
    public static Scanner in = new Scanner(System.in);
    public static void main (String[] args){
        System.out.println("Você está na frente de uma caverna.");
        System.out.println("Boa! Você foi para: " + direction());
    }

    private static String direction (){
        System.out.println("w = frente | a = esquerda | d - direita | s - voltar");
        String comando = "";
        while(comando.isBlank()) {
            System.out.println("Digite uma direção: ");
            comando = in.nextLine();
            if (comando.equals("w") || comando.equals("a") || comando.equals("s") || comando.equals("d")){
                return comando;
            }else{
                System.out.println("ATENÇÃO: Escolha uma opção válida. (Exemplo: w)");
                comando = "";
            }
        }
        return comando = "Erro no código, a variável 'comando' não está vazia.";
    }
}
