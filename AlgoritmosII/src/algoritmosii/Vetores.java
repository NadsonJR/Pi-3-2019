/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosii;

/**
 *
 * @author mt12732
 */
public class Vetores {

    public static void main(String[] args) {
        //int[] Vetor = {1,2,3,4,5,6,7,8,9,10};
        int[] Vetor1 = {5, 8, 9, 1, -3, 2, 7,};
        int Menor = 0;
        Menor = MenorValor(Vetor1);
        System.out.println("O menor valor é: " + Menor);
        //for (int i = 0; i < Vetor.length; i++) {
        //    System.out.println("Vetor: "+Vetor[i]);
        //}
        //TrocaDeValores(Vetor);
        //for (int i = 0; i < Vetor.length; i++) {
        //    System.out.println("Vetor: "+Vetor[i]);
        //}
    }

    static void TrocaDeValores(int[] Vetor) {
        for (int i = 0; i < Vetor.length; i++) {
            if (Vetor[i] % 2 == 0) {
                Vetor[i] = 0;
            } else {
                Vetor[i] = 1;
            }

        }
    }

    static int MenorValor(int[] Vetor) {
        int Menor = 0;
        for (int i = 0; i < Vetor.length; i++) {
            if (Menor > Vetor[i]) {
                Menor = Vetor[i];
            }
        }
        return Menor;
    }
}
