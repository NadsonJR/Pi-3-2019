/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosii.ProvaDeCompensacao;

import java.util.Scanner;

/**
 *
 * @author mt12732
 */
public class Exe_4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um número impar para a fatorial dupla: ");
        int numero = input.nextInt();
        while(numero % 2 == 0){
        System.out.println("Digite um número impar para a fatorial dupla: ");
        numero = input.nextInt();
        }
        numero = fatorialDupla(numero);
        System.out.println("O resultado da fatorial dupla é: " + numero);

    }

    static int fatorialDupla(int numero) {
        int resultado = 1;
        for (int i = 0; i <= numero; i++) {
            if (i % 2 != 0) {
                resultado = resultado * i;
            }
            
        }
        return resultado;
    }
}
