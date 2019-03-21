
import algoritmosii.Retangulo;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antonio.ncgjunior
 */
public class Calculo {
    public static void main(String[] args) {
        Retangulo r = new Retangulo();
        float base =0;
        float altura = 0;
        Scanner input =new Scanner(System.in);
        System.out.println("Digite a altura do retângulo: ");
        altura = input.nextFloat();
        System.out.println("Agora digite a base: ");
        base = input.nextFloat();
        r.setAltura(altura);
        r.setBase(base);
        
        float result = r.calcularArea(base, altura);
        System.out.println(result);
        }
}
