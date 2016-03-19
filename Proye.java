
import javax.swing.*;
public class Proye {
  private static String unidadDeDatos,dividendoC,cociente,crc="",lamii="";
    
  private static void calcularCRC(int[] dividendo,int [] divisor,int[] auxiliar){
    int mult,j; cociente="";
    //System.out.print("\nDividendo: "); imprimir(divisor);
    //System.out.print("\nDivisor: "); imprimir(dividendo);    
     for(int i=dividendo.length;i<divisor.length+1;i++){  
      if(auxiliar[0]==1)  
         mult=1;   
      else    
         mult=0;
      cociente =cociente+""+mult;  
       // guardado(auxiliar,dividendo.length);
    //imprimir2(auxiliar, divisor.length);
    String aucito="";
    for(int jkm=0;jkm<auxiliar.length;jkm++){
        aucito =String.valueOf(auxiliar[jkm]);
        lamii=lamii+aucito;
    }
    lamii=lamii+"\n";
    for(int jkm=0;jkm<auxiliar.length;jkm++){
        aucito =String.valueOf(dividendo[jkm]);
        lamii=lamii+aucito;
     }
    lamii=lamii+"\n";


        //imprimir e disor si el mult es 1
        //si no imprimes 0000 
      for(j=dividendo.length-1;j>0;j--){
        if(auxiliar[j]==dividendo[j]*mult)    
           auxiliar[j]=0;    
           else    
           auxiliar[j]=1;
      }
      // imprimes auxiliar 
     /*
      for (int hj =0;hj<auxiliar.length;hj++){
      System.out.print(auxiliar[hj]);
    }*/
      for(int k=0; k<dividendo .length-1;k++)
         auxiliar[k]=auxiliar[k+1];
      if(i<divisor.length){ 
        j=dividendo.length-1; 
        auxiliar[j]=divisor[i];  
      }
    } 
   
     casita(dividendo,divisor,cociente);
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
  private static void imprimir2(int[]arreglo, int larguito){ 
      String arm="";
      int couta = 0;
    for(int a=0;a<arreglo.length;a++){
            arm=arm+arreglo[a]+"\n";
            couta=0;       
    }
     System.out.print(arm);
  }
 
  private static void guardado(int [] rino, int kilo){
        String iop="";int hjk=0;
      for (int jk=0;jk<rino.length;jk++){
            if(hjk==kilo){
                iop=String.valueOf(rino[jk]);
                lamii=lamii+rino[jk]+"\n";
            }else{
            iop=String.valueOf(rino[jk]);
                lamii=lamii+rino[jk];
            }
      }
    }
  
  
  private static void casita(int [] uno, int [] dos,String cociente){
      String aux="",aux2="", raya="", esp="", pat="";
        for(int i=0;i<uno.length; i++){
            aux=aux+uno[i];           
        }
        for(int i=0;i<dos.length; i++){
            aux2=aux2+dos[i];           
        }
        for(int i=0;i<dos.length; i++){
            raya=raya+"_";
        }
        
        for(int i=0;i<uno.length; i++){
            esp=esp+" ";
        }
        int espacios=1+aux.length()+1+aux2.length();
       // pat ="\n"+esp+" "+cociente+"\n"+aux+"|"+aux2;
         //char [] mall=aux2.toCharArray;
           
       
        System.out.println("\n"+esp+" "+cociente+"\n"+aux+"|"+aux2+crc);  
      
  }
  public static void main (String args[]){
    unidadDeDatos=JOptionPane.showInputDialog("Introduzca el Dividendo");
    dividendoC=JOptionPane.showInputDialog("Introduzca el Divisor");
    int divisor[]=new int [unidadDeDatos.length()+dividendoC.length()-1];  llenarArreglo(divisor,unidadDeDatos);
    int dividendo[]=new int [dividendoC.length()];  llenarArreglo(dividendo,dividendoC); 
    int auxiliar[]=new int [dividendoC.length()]; llenarArreglo(auxiliar,unidadDeDatos);
    System.out.print("\n\n*******Datos Principales******\nUnidad De Datos : "+unidadDeDatos+"\nDivisor : "+dividendoC);
    System.out.print("\n\n----Calculo del CRC----\n");
    calcularCRC(dividendo,divisor,auxiliar);
    System.out.print(lamii);
    lamii="";
    System.out.print("\nCRC : ");
    asignarCRC(auxiliar);
    llenar(divisor,crc);
    llenarArreglo(auxiliar,unidadDeDatos); 
    System.out.print("\n----Comprobacion del CRC----");
    calcularCRC(dividendo,divisor,auxiliar);
        System.out.print(lamii);
    System.out.print("\nResultado de la comprobacion : ");
    asignarCRC(auxiliar);
  }  
}