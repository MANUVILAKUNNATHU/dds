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
public class pcafinal {
    static    double [][]transevctr;
    static  double [][]transadj;
    static  double [][]multply=new double[7][255];
public double[][] pcafinalstep(double[][]adjst,double[][]evector)
    {
       transadj=new double[adjst[0].length][adjst.length];
  transevctr =new double[evector[0].length][evector.length];
      double [][]multply=new double[evector[0].length][adjst.length];
       for(int i=0;i<adjst[0].length;i++)
       {
           for(int j=0;j<adjst.length;j++)
           {
           transadj[i][j]=adjst[j][i];
           
           }
       }
       //print transadj
     /*   for (int m = 0; m <transadj.length; m++) {
    for (int n = 0; n <transadj[0].length; n++) {
        System.out.print(transadj[m][n] + " ");
    }
    System.out.print("\n\n");
       
       
        }*/
       
       for(int i=0;i<evector[0].length;i++)
       {
           for(int j=0;j<evector.length;j++)
           {
           transevctr[i][j]=evector[j][i];
           
           }
       }
       for(int i=0;i<transevctr.length;i++)
        {
            for(int j=0;j<transadj[0].length;j++)
            {
                multply[i][j]=0;
                for(int k=0;k<transadj.length;k++)
                {
                    multply[i][j]=multply[i][j]+transevctr[i][k]*transadj[k][j];
                }
            }
        }
       return multply;
   /*    for (int m = 0; m <multply.length; m++) 
       {
    for (int n = 0; n <multply[0].length; n++) 
    {
        System.out.print(multply[m][n] + " ");
    }
    System.out.print("\n\n");
       
       
        }*/
    }
}
