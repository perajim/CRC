
class CRC2 {

     public static void main(String args[]){
         int [] d = new int [9];
         int [] dv = new int [4];
         dv[0]=1;
         dv[1]=1;
         dv[2]=0;
         dv[3]=1;
         d[0]=1;
         d[1]=0;
         d[2]=0;
         d[3]=1;
         d[4]=0;
         d[5]=0;
         d[6]=0;
         d[7]=0;
         d[8]=0;
         
         int la = d.length;
         int minus = dv.length;
      
         String  disp="", aux="", lmb="", fdg="";
         
       for (int i=0; i<la;i++){             
             aux=String.valueOf(d[i]);
             disp=disp+aux;
            }
            
             for (int i=0; i<minus;i++){             
             lmb=String.valueOf(dv[i]);
             fdg=fdg+lmb;
            }
           int  numero = Integer.parseInt(disp);
            int dec= Integer.parseInt(disp,2);
            
            int dec2=Integer.parseInt(fdg,2);
            
            int crc=dec2/dec;
             System.out.println(dec);
              System.out.println(dec2);
               System.out.println(crc);
           //int finalito = String.valueOf(crc);
           String vgh=Integer.toBinaryString(crc);
            System.out.println(vgh);
        }        
    
}
