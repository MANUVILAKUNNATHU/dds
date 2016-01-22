/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rotationforest;

import static Rotationforest.Mean.sum;

/**
 *
 * @author MANU WILSON
 */
public class PCAMEAN {
  
     public  double[][] getMeanAdjusted(double[][] input, double[] mean) {
    int nRows = input.length;
    int nCols = input[0].length;
    double[][] ret = new double[nRows][nCols];
    for (int row = 0; row < nRows; row++) {
      for (int col = 0; col < nCols; col++) {
        ret[row][col] = input[row][col] - mean[col];
      }
    }
    return ret;
  }
     public double[][]covar(double[][] input)
     {
          int m = input[0].length;
           int n  = input[0].length;
           int p=input.length;
           double[][] digmatrix = new double[p][n];
          double[][] comatrix = new double[m][n];
          double[][] cpymatrix = new double[p][n];
          for(int i=0;i<p;i++)
          {
           for(int j=0;j<n;j++)
           {
           cpymatrix[i][j]=input[i][j]*input[i][j];
           
           }
          
          }
        double mean[];
        mean = new double[input[0].length];
         for (int j = 0; j < mean.length; j++){
    sum[j]=0;
    
    }
          for(int l=0;l<mean.length;l++){
      for (int j = 0; j < cpymatrix.length; j++){
        
       //System.out.print(c[j][l]);
        sum[l]=sum[l]+cpymatrix[j][l];
        
       // sum2[j]+=val + val ;
       
        
      }
      //printin sum
      //System.out.print(sum[l]+"\n");
    }
           for (int l = 0; l <mean.length; l++){
          //System.out.print(sum[l]);
        // System.out.print("\n\n\n");
      sum[l] /= (cpymatrix.length)-1;
     // sum2[j] /= c.length;
      
      mean[l] = sum[l];
      }
         
         for(int i=0;i<m;i++)
          {
           for(int j=0;j<n;j++)
           {
               if(i==j)
               {
           digmatrix[i][j]=mean[i];
               }
           }
          
          } 
        return digmatrix;
         
     }
     
     
}
