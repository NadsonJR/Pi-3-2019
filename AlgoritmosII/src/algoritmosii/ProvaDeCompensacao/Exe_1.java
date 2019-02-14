/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosii.ProvaDeCompensacao;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mt12732
 */
public class Exe_1 {
      public static void main(String[] args) {
        int numero=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o numero que deseja procurar na lista: ");
        numero = input.nextInt();
        int[] vetor = new int[10];
        vetor = PopularVetor(vetor);
        int resultado=Vetores(vetor, numero);
        
        if(resultado!= -1){
            System.out.println("O número: " + numero + " se encontra na posicão: " + resultado +" do vetor!" );
        }else{
            System.out.println("Número não encontrado!");
        }
    }
    static int Vetores(int[]Vetor, int valorProcurar){
        int index = -1;
            for(int i = 0; i<Vetor.length;i++){
                if(Vetor[i]== valorProcurar){
                    index=i;
                }
            }
            
        return index;
    }
    static int [] PopularVetor(int[] vetor){
        
        for(int i = 1; i<vetor.length; i++){
            vetor[i] = i;
            System.out.println(vetor[i]);
        }
        return vetor;
    }
}
