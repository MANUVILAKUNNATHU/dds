/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rotationforest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;


import org.six11.util.Debug;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;
import org.apache.commons.math3.linear.RealMatrix;


/**
 *
 * @author MANU WILSON
 */
public class eigencal {
     static double[][]d;
    double[] eigenvector ;
  Matrix covMatrix;
  EigenvalueDecomposition eigenstuff;
  double[] eigenvalues;
  Matrix eigenvectors;
  SortedSet<PrincipleComponent> principleComponents;
  double[] means;

  public double[][] eigenv(double[][] input) {
      int a=input.length;
      int b=input[0].length;
      double [][]cov=new double[a][b]; 
      try {
    for (int m = 0; m <input.length; m++) {
    for (int n = 0; n <input[0].length; n++) {
       cov[m][n]=input[m][n];
    }
    }
  covMatrix = new Matrix(cov);
    eigenstuff = covMatrix.eig();
    eigenvalues = eigenstuff.getRealEigenvalues();
    eigenvectors = eigenstuff.getV();
    double[][] vecs = eigenvectors.getArray();
    int numComponents = eigenvectors.getColumnDimension(); // same as num rows.
    principleComponents = new TreeSet<PrincipleComponent>();
    d=new double[numComponents][numComponents];
    for (int i = 0; i < numComponents; i++) {
        eigenvector = new double[numComponents];
      for (int j = 0; j < numComponents; j++) {
        eigenvector[j] = vecs[i][j];
       d[i][j]=eigenvector[j];
      // System.out.print(eigenvector[j]);
      // System.out.print("\n\n");
       
      }
       principleComponents.add(new PrincipleComponent(eigenvalues[i], eigenvector));
    }
      /*    System.out.println("\n\n");
          System.out.println("Eigen values are:");
          System.out.println("\n\n");
    
    for (int n = 0; n <eigenvalues.length; n++) 
                    {
                      System.out.print( eigenvalues[n]+ " ");
                     }*/
   
      //print eigen vector
       
    
      //print new eigenvector
   /*   d=new double[numComponents][numComponents];
      for(int m=0;m<numComponents;m++)
      {
    for (int j = 0; j < numComponents; j++) {
        
        d[m][j]=eigenvector[j];
      }
      
       
      }*/
    //print eigenvector
        

   
      return d;
    
      
    
  
      }

    catch(Exception e)  {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
   public List<PrincipleComponent> getDominantComponents(int n) {
    List<PrincipleComponent> ret = new ArrayList<PrincipleComponent>();
    int count = 0;
    for (PrincipleComponent pc : principleComponents) {
      ret.add(pc);
      count++;
      if (count >= n) {
        break;
      }
    }
    return ret;
  }
   public static Matrix getDominantComponentsMatrix(List<PrincipleComponent> dom) {
    int nRows = dom.get(0).eigenVector.length;
    int nCols = dom.size();
    Matrix matrix = new Matrix(nRows, nCols);
    for (int col = 0; col < nCols; col++) {
      for (int row = 0; row < nRows; row++) {
        matrix.set(row, col, dom.get(col).eigenVector[row]);
      }
    }
    return matrix;
  }

  public int getNumComponents() {
    return eigenvalues.length;
  }

  public static class PrincipleComponent implements Comparable<PrincipleComponent> {
    public double eigenValue;
    public double[] eigenVector;

    public PrincipleComponent(double eigenValue, double[] eigenVector) {
      this.eigenValue = eigenValue;
      this.eigenVector = eigenVector;
    }

    public int compareTo(PrincipleComponent o) {
      int ret = 0;
      if (eigenValue > o.eigenValue) {
        ret = -1;
      } else if (eigenValue < o.eigenValue) {
        ret = 1;
      }
      return ret;
    }

    public String toString() {
      return "Principle Component, eigenvalue: " + Debug.num(eigenValue) + ", eigenvector: ["
          + Debug.num(eigenVector) + "]";
    }
  }

  
}