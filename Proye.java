
import javax.swing.*;
public class Proye {
  private static String unidadDeDatos,dividendoC,cociente,crc="";
    
  private static void calcularCRC(int[] dividendo,int [] divisor,int[] auxiliar){
    int mult,j; cociente="";
    System.out.print("\nDividendo: "); imprimir(divisor);
    System.out.print("\nDivisor: "); imprimir(dividendo);
     for(int i=dividendo.length;i<divisor.length+1;i++){  
      if(auxiliar[0]==1)  
         mult=1;   
      else    
         mult=0;
      cociente =cociente+""+mult;   
      for(j=dividendo.length-1;j>0;j--){
        if(auxiliar[j]==dividendo[j]*mult)    
           auxiliar[j]=0;    
           else    
           auxiliar[j]=1;
      }
      for(int k=0; k<dividendo .length-1;k++)
         auxiliar[k]=auxiliar[k+1];
      if(i<divisor.length){ 
        j=dividendo.length-1; 
        auxiliar[j]=divisor[i];  
      }
    } 
    System.out.print("\nCociente : "+cociente);
  }

   private static void llenarArreglo(int []arreglo,String cadena){
    for(int i=0;i<arreglo.length;i++){
      if(i<cadena.length()) 
        arreglo[i]=cadena.charAt(i)-48;
      else 
        arreglo[i]=0;
    }  
  }
  
   private static void llenar(int []arreglo,String crc){
    int k=0;   
    for(int i=arreglo.length-crc.length();i<arreglo.length;i++){
        arreglo[i]=crc.charAt(k)-48;   k++;
    }  
  }
  
  private static void asignarCRC(int[]arreglo){  
    for(int a=0;a<arreglo.length-1;a++){
      System.out.print(arreglo[a]);
      crc=crc+""+arreglo[a];
    } 
  }
  
  private static void imprimir(int[]arreglo){  
    for(int a=0;a<arreglo.length;a++)
      System.out.print(arreglo[a]);
  }
  
  public static void main (String args[]){
    unidadDeDatos=JOptionPane.showInputDialog("Introduzca el Dividendo");
    dividendoC=JOptionPane.showInputDialog("Introduzca el Divisor");
    int divisor[]=new int [unidadDeDatos.length()+dividendoC.length()-1];  llenarArreglo(divisor,unidadDeDatos);
    int dividendo[]=new int [dividendoC.length()];  llenarArreglo(dividendo,dividendoC); 
    int auxiliar[]=new int [dividendoC.length()]; llenarArreglo(auxiliar,unidadDeDatos);
    System.out.print("\n\n*******Datos Principales******\nUnidad De Datos : "+unidadDeDatos+"\nDivisor : "+dividendoC);
    System.out.print("\n\n----Calculo del CRC----");
    calcularCRC(dividendo,divisor,auxiliar);
    System.out.print("\nCRC : ");
    asignarCRC(auxiliar);
    llenar(divisor,crc);
    llenarArreglo(auxiliar,unidadDeDatos); 
    System.out.print("\n----Comprobacion del CRC----");
    calcularCRC(dividendo,divisor,auxiliar);
    System.out.print("\nResultado de la comprobacion : ");
    asignarCRC(auxiliar);
  }  
}