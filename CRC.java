import java.util.Scanner;
public class CRC {
  private static String unidadDeDatos,dividendoC,cociente,crc="",polinomio="" ;
  
  private static void calcularCRC(int[] dividendo,int [] divisor,int[] auxiliar){
    int mult,j; cociente="";
    System.out.print("\nDIVISOR = "+dividendoC+ "   Datos en decimal: ");convertir(dividendoC);   
    System.out.print("\nDIVIDENDO = "+unidadDeDatos+"   Datos en decimal: ");convertir(unidadDeDatos);  System.out.print("\n");
    imprimir(divisor);
     for(int i=dividendo.length;i<divisor.length+1;i++){  
      if(auxiliar[0]==1)  
         mult=1;   
      else    
         mult=0;
      cociente =cociente+""+mult;  
      if(mult==1)
        imprimir(dividendo);
      else 
        imprimirCeros();
      System.out.print("\n____________"); 
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
      if(i<divisor.length)
      imprimir(auxiliar);
    } 
    System.out.print("\n");
    asignarCRC(auxiliar);
  }

  private static void llenarArreglo(int []arreglo,String cadena){
    for(int i=0;i<arreglo.length;i++){
      if(i<cadena.length()) 
        arreglo[i]=cadena.charAt(i)-48;
      else 
        arreglo[i]=0;
    }  
  }
  
  private static void imprimirCeros(){
     System.out.print("\n");
     for(int c=0;c<dividendoC.length();c++)
       System.out.print("0");
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
       System.out.print("\n");  
    for(int a=0;a<arreglo.length;a++)
      System.out.print(arreglo[a]);
   
  }
  
  private static void polinomio(int arreglo[]){
    int potencia=arreglo.length-1;
    for(int i=0;i<arreglo.length-1;i++){
      if(arreglo[i]==1)
        polinomio=polinomio+"x^"+potencia+"+";
      potencia--;  
    }  
    if(arreglo[arreglo.length-1]==1)
     polinomio=polinomio+"1";
  }
  
  private static void convertir(String lk){     
      int v = Integer.parseInt(lk,2);
      System.out.print(v);
    
  }
    
  public static void main (String args[]){
     Scanner teclado=new Scanner (System.in); 
     System.out.print("Introduzca el Dividendo  ");
     unidadDeDatos=teclado.nextLine();
     System.out.print("Introduzca el Divisor  ");
     dividendoC=teclado.nextLine();
    int divisor[]=new int [unidadDeDatos.length()+dividendoC.length()-1];  llenarArreglo(divisor,unidadDeDatos);
    int dividendo[]=new int [dividendoC.length()];  llenarArreglo(dividendo,dividendoC); 
    int auxiliar[]=new int [dividendoC.length()]; llenarArreglo(auxiliar,unidadDeDatos);
    System.out.print("\n    EMISOR");
    calcularCRC(dividendo,divisor,auxiliar);
    System.out.print(" <---CRC\nCOCIENTE = "+cociente);
    polinomio(dividendo);
    System.out.print("\nPOLINOMIO = "+polinomio);
    llenar(divisor,crc);
    llenarArreglo(auxiliar,unidadDeDatos); 
    System.out.print("\n    RECEPTOR");
    calcularCRC(dividendo,divisor,auxiliar);
    System.out.print("  <---RESIDUO\nCOCIENTE = "+cociente);
    asignarCRC(auxiliar);
      System.out.print("\nPOLINOMIO = "+polinomio);
  }  
} 