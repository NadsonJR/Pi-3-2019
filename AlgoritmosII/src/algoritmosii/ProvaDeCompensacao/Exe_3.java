/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosii.ProvaDeCompensacao;

/**
 *
 * @author mt12732
 */
public class Exe_3 {

    public static void main(String[] args) {
        int[] vetor = {2, 9, 6, 1, 8, 0};
        
        //bubblesort(vetor);
        
        bubblesort(vetor, 0);
        
        for(int i = 0; i<vetor.length;i++){
            System.out.println(vetor[i]);
        }
    }
    static void bubblesort(int []vetor){
        int aux = 0;
        for(int i = 0; i<vetor.length-1;i++){
            for(int j = 0; j<vetor.length-i-1; j++){
                if(vetor[j] > vetor[j+1]){
                    aux=vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                    
                }
            }
        }
    }
    
    static void bubblesort(int []vetor, int count){
        int aux = 0;
        
        if ((count < vetor.length) && vetor[count] <= vetor[count + 1])
            bubblesort(vetor, count++);
        
        for(int i = 0; i<vetor.length-1;i++){
            for(int j = 0; j<vetor.length-i-1; j++){
                if(vetor[j] > vetor[j+1]){
                    aux=vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                    
                }
            }
        }
    }
}
