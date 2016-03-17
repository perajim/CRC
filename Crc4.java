/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author Christian
 */
import java.util.Scanner;

public class Crc4 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int ndivisor, divisor[], nbits, dividendo[], arregcero[], aux[], comp;

        System.out.print("Introduce el numero de bits: ");
        nbits = sc.nextInt();

        System.out.print("Introduce el numero de bits del divisor : ");
        ndivisor = sc.nextInt();

        dividendo = new int[nbits + ndivisor]; //calcular el tamaño del dividendo
        divisor = new int[ndivisor];

        System.out.print("Introduce los bits del dividendo (uno por uno) : ");
        for (int i = 0; i < nbits; i++) {
            dividendo[i] = sc.nextInt();
        }
        for (int i = 0; i < ndivisor - 1; i++) {
            dividendo[nbits + i] = 0; //agregamos los ceros dependiendo del divisor
        }

        System.out.print("Introduce los bits del divisor (uno por uno) : ");
        for (int j = 0; j < ndivisor; j++) {
            divisor[j] = sc.nextInt(); //ingreso de bits del divisor
        }

        //realizaremos los calculos con un xor
        aux = new int[ndivisor + nbits];
        for (int i = 0; i < ndivisor; i++) {
            aux[i] = dividendo[i];
        }
        arregcero = new int[ndivisor];
        for (int i = 0; i < ndivisor; i++) {
            arregcero[i] = 0;
        }
        for (int i = 0; i < nbits; i++) {
            int k = 0;
            comp = aux[i];
            for (int j = i; j < ndivisor + i; j++) {
                if (comp == 0) {
                    aux[j] = xor(aux[j], arregcero[k]);
                } else {
                    aux[j] = xor(aux[j], divisor[k]);
                }
                k++;
            }
            aux[ndivisor + i] = dividendo[ndivisor + i];
        }
        System.out.print("El residuo es: ");
        for (int i = nbits; i < nbits + ndivisor - 1; i++) {
            dividendo[i] = aux[i];
            System.out.print(dividendo[i]);
        }
        System.out.print("\nEl dividendo mas el residuo es: \n");
        for (int i = 0; i < nbits + ndivisor - 1; i++) {
            System.out.print(dividendo[i]);
        }
    }

    public static int xor(int x, int y) {
        if (x == y) {
            return (0);
        } else {
            return (1);
        }
    }
}
