/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosii;

import java.util.Scanner;

/**
 *
 * @author mt12732
 */
public class AlgoritmosII {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int n1 = input.nextInt();
        //System.out.println("Digite um número: ");
        //int n2 = input.nextInt();
        //int result = SomaDeIntervalos(n1, n2);
        //String resultado1 = imparOuPar(n1);
        int exe3 = nAoQuadrado(n1);
        //int exe2= nAoQuadrado(n2);
        //System.out.println("O seu número é: " + resultado1);
        //System.out.println("A soma de valor: " + result);
        System.out.println("O primeiro número ao quadrado é: " + exe3);
        //System.out.println("O primeiro número ao quadrado é: " +exe2);
    }

    static String imparOuPar(int n1) {
        boolean retorno = false;
        String result = "";
        if (n1 % 2 == 0) {
            result = "par";
            retorno = true;
        } else {
            retorno = false;
            result = "impar";
        }

        return result;
    }

    static int SomaDeIntervalos(int m, int n) {
        int resultado = 0;
        if (m > n) {
            for (int i = n; i < m; i++) {
                resultado += i;
            }
        } else {
            for (int i = m; i < n; i++) {
                resultado += i;
            }
        }
        return resultado;
    }

    static int nAoQuadrado(int n1) {
        int result = 0;
        int i = 1;
        int l = 1;
        while(l <= n1){
            if (i % 2 != 0) {
                System.out.println(i);
                result += i;
                l++;
            }
            i++;
        }
        return result;
    }
}
