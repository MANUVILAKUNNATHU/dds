/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rotationforest;

/**
 *
 * @author MANU WILSON
 */

public class Mean {
    
    
     static   double [][]a=new double[303][7];
       static    double [][]b=new double[303][7];
       static    double [][]c=new double[225][7];
       static    double [][]d=new double[225][7];
     static  double sum[] = new double[7];
       
     static double inputs[][];
    public double[] calmean(double[][] c){
        double mean[] ; 
         //calculating mean
        mean = new double[c[0].length];
    // System.out.print(c.length);
    
       
   
   // double sum[] = new double[mean.length];
    for (int j = 0; j < mean.length; j++){
    sum[j]=0;
    
    }
    
    //double sum2[] = new double[mean.length] ;
    for(int l=0;l<mean.length;l++){
      for (int j = 0; j < c.length; j++){
        
       //System.out.print(c[j][l]);
        sum[l]=sum[l]+c[j][l];
        
       // sum2[j]+=val + val ;
       
        
      }
      //printin sum
      //System.out.print(sum[l]+"\n");
    }
      for (int l = 0; l <mean.length; l++){
          //System.out.print(sum[l]);
        // System.out.print("\n\n\n");
      sum[l] /= c.length;
     // sum2[j] /= c.length;
      
      mean[l] = sum[l];
      }
     
     
        
         
         return mean;
    }
}
