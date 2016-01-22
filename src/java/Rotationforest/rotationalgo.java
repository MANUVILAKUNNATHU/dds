/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rotationforest;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.math3.linear.RealMatrix;
import readcsv.read;
import readcsv.values;
/**
 *
 * @author MANU WILSON
 */
public class rotationalgo {
  static  double [][]rot;
       
    // static  double inputs[][];
     public static void main(String[] args) {
        // TODO code application logic here
         
           double [][]a=new double[303][7];
           double [][]b=new double[303][7];
           double [][]c=new double[225][7];
           double [][]d=new double[225][7];
           double sum[] = new double[7];
           double mean[] ;
           double [][] inputs=new double[303][14];
            final RealMatrix cov;
            final RealMatrix cov1;
         
            read obj = new read();
            ArrayList<values> ar = new ArrayList<values>();
            ar = obj.run();
            // System.out.println("records= " + ar.size());
            Iterator<values> arIterator = ar.iterator();
            int i=0;
            while (arIterator.hasNext()) {
                values values =arIterator.next();
                //inputs= new double[][]{{values.age,values.sex,values.cp,values.restbps,values.chol,values.fbs,values.restecg,values.thalach,values.exang,values.oldpeak,values.slope,values.ca,values.thal,values.clas }};
          
          
                inputs[i][0]=values.age;
                inputs[i][1]=values.sex;
                inputs[i][2]=values.cp;
                inputs[i][3]=values.restbps;
                inputs[i][4]=values.chol;
                inputs[i][5]=values.fbs;
                inputs[i][6]=values.restecg;
                inputs[i][7]=values.thalach;
                inputs[i][8]=values.exang;
                inputs[i][9]=values.oldpeak;
                inputs[i][10]=values.slope;
                inputs[i][11]=values.ca;
                inputs[i][12]=values.thal;
                inputs[i][13]=values.clas;
                i++;
             
                /*for (int m = 0; m <inputs.length; m++) {
                for (int n = 0; n <inputs[0].length; n++) {
                //System.out.print(inputs[m][n] + " ");
                }
                //System.out.print("\n\n\n");
                } */
            }
        /*  final   double [][]in =new double[303][14];
         for (int r=0; r<inputs.length; r++) {
        for (int c=0; c<inputs[r].length; c++) {
         in[r][c]=inputs[r][c];
        }
        }*/
        
    
  
       for (int m = 0; m <inputs.length; m++) {
        for (int n = 0; n <=6; n++) {
            a[m][n]=inputs[m][n];
        }
    }
        
 
      
// System.out.println(" main inputs = " + inputs);
    // Corresponding outputs, xor training data
    /*    
     for (int m = 0; m <inputs.length; m++) {
    for (int n = 0; n <=6; n++) {
        System.out.print(a[m][n] + " ");
    }
    System.out.print("\n\n\n");
} */

       
       
       int k=7;
       /*
       for (int m = 0; m <inputs.length; m++) {
        for (int n = 0; n <=6 && k<=13; n++,k++) {
                b[m][n]=inputs[m][k];
                System.out.print(inputs[m][k] + "");
           }
           System.out.println("\n");
        }
       */
       
     
       for (int m = 0; m <inputs.length; m++) {
           for(int n=0;n<7;n++)
           {
               b[m][n]=inputs[m][k];
               k++;
           }
           k=7;
       }
       
      
         /*      
       for (int m = 0; m <b.length; m++) {
        for (int n = 0; n <=6; n++) {
        System.out.print(b[m][n] + " ");
    }
    System.out.print("\n\n"); 
        }
       */
       
       for (int m = 0; m <225; m++) {
        for (int n = 0; n <=6; n++) {
            c[m][n]=a[m][n];
        }
        }
       
   
     //printing c
       /*
       for (int m = 0; m <225; m++) {
    for (int n = 0; n <=6; n++) {
        System.out.print(c[m][n] + " ");
    }
    System.out.print("\n\n");
       
       
        }
     */
       
       

   
       for (int m = 0; m <225; m++) {
    for (int n = 0; n <=6; n++) {
        d[m][n]=b[m][n];
        
        
    }
    
       } 
       
       
   
  Mean ob=new Mean();
  PCAMEAN ob1=new PCAMEAN();
  Covariance b1=new Covariance();
  
 
  double[]meanc=ob.calmean(c);
  double[]meand=ob.calmean(d);
  double[][]adc=ob1.getMeanAdjusted(c, meanc);
  double[][]add=ob1.getMeanAdjusted(d, meand);
   cov=b1.computeCovarianceMatrix(adc);
   cov1=b1.computeCovarianceMatrix(add);
   
   
   
 // double[][]digi=ob1.covar(adc);
   int p=cov.getRowDimension();
   int  r=cov.getColumnDimension();
  double [][]cc=new double[p][r];
  double [][]cd=new double[p][r];
   //print realmatrix
   
  for (int m = 0; m <p; m++) {
    for (int n = 0; n <r; n++) {
       cc[m][n]=cov.getEntry(m, n);
    }
    
       
       
        }
  for (int m = 0; m <p; m++) {
    for (int n = 0; n <r; n++) {
       cd[m][n]=cov1.getEntry(m, n);
    }
   
       
       
        }
   
  
    
          eigencal e=new eigencal();  
        double[][]evectorc=e.eigenv(cc);
        double[][]evectord=e.eigenv(cd);
      
       
    
    
    int r1=evectord.length + evectorc.length;
    int r2=evectord[0].length + evectorc[0].length;
    
    rot=new double[r1][r2];
     
    for (int m = 0; m <r1; m++) {
        for (int n = 0; n <r2; n++) {
            rot[m][n]=0;
        }
    }
     
    for (int m = 0; m <evectorc.length; m++) {
        for (int n = 0; n <evectorc[0].length ; n++) {
            rot[m][n]=evectorc[m][n];
        }
        
      
        for (int m1 = 7, m3=0; m <evectord.length; m1++,m3++) {
        for (int n = 7,m4=0; n <evectord[0].length ; n++, m4++) {
            rot[m][n]=evectord[m3][m4];
        }
       
        }
       
        
        }
    for (int m = 0; m <r1; m++) {
    for (int n = 0; n <r2; n++) {
        System.out.print(rot[m][n] + " ");
    }
    System.out.print("\n\n");
       
       
        }
  
   
     System.out.println("Splited the data set into two arrays a & b");
     System.out.println("Readed" + "\t" + c.length + "\t" + "records and 7 attributes in array a");
      System.out.println("Readed" + "\t" + d.length + "\t" + "records and 7 attributes in array b"); 
     }
     
     
  
     
}
