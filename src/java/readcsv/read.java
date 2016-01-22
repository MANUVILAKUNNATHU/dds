/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readcsv;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author MANU WILSON
 */
public class read {
    public ArrayList<values> run() {
        String csvFile = "resource/traindataset2cls.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        final ArrayList<values> inputLayer = new ArrayList<values>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] inputRow = line.split(cvsSplitBy);
                values rowObj = new values();
                if(Integer.parseInt(inputRow[0])>50 && Integer.parseInt(inputRow[0])<=100){
                   rowObj.age= 1;
               }
                else  if(Integer.parseInt(inputRow[0])>0 && Integer.parseInt(inputRow[0])<50){
                    rowObj.age= 0;
                }
                if(Integer.parseInt(inputRow[1])==1){
                    rowObj.sex= 1;
                }
                else if(Integer.parseInt(inputRow[1])==0){
                    rowObj.sex=0;
                }
                
                if(Integer.parseInt(inputRow[2])==1){
                    rowObj.cp= 1;
                }
                else  if(Integer.parseInt(inputRow[2])==2){
                    rowObj.cp= 2;
                }
                else  if(Integer.parseInt(inputRow[2])==3){
                    rowObj.cp= 3;
                }     
                 else  if(Integer.parseInt(inputRow[2])==4){
                    rowObj.cp= 4;
                }
                if(Integer.parseInt(inputRow[3])>=90 && Integer.parseInt(inputRow[3])<=130){
                    rowObj.restbps= 0;
                }
                else  if(Integer.parseInt(inputRow[3])<90){
                    rowObj.restbps= -1;
                }
                else  if(Integer.parseInt(inputRow[3])>130){
                    rowObj.restbps= 1;
                }
                  if(Integer.parseInt(inputRow[4])<200){
                    rowObj.chol=0;
                }
                else  if(Integer.parseInt(inputRow[4])>=200){
                    rowObj.chol= 1;
                }
                 if(Integer.parseInt(inputRow[5])==0){
                    rowObj.fbs= 0;
                }
                 else  if(Integer.parseInt(inputRow[5])==1){
                    rowObj.fbs= 1;
                }
                 if(Integer.parseInt(inputRow[6])==0){
                    rowObj.restecg= 0;
                }
                 else if(Integer.parseInt(inputRow[6])==2){
                    rowObj.restecg= 2;
                }
                 if(Integer.parseInt(inputRow[7])<120 ){
                    rowObj.thalach= -1;
                }
                 else if(Integer.parseInt(inputRow[7])>=120 && Integer.parseInt(inputRow[7])<=160){
                    rowObj.thalach= 0;
                }
              else if(Integer.parseInt(inputRow[7])>160 ){
                    rowObj.thalach= 1;
                }
                 if(Integer.parseInt(inputRow[8])==1 ){
                    rowObj.exang= 1;
                }
              else  if(Integer.parseInt(inputRow[8])==0){
                    rowObj.exang= 0;
                }
               if(Float.parseFloat(inputRow[9])>=0 && Float.parseFloat(inputRow[9])<=2){
                    rowObj.oldpeak= 0;
                }
               else  if(Float.parseFloat(inputRow[9])>2 && Float.parseFloat(inputRow[9])<=4){
                    rowObj.oldpeak= 1;
                }
                 if(Integer.parseInt(inputRow[10])==1){
                    rowObj.slope= -1;
                }
                else  if(Integer.parseInt(inputRow[10])==2){
                    rowObj.slope= 0;
                }
                  else  if(Integer.parseInt(inputRow[10])==3){
                    rowObj.slope= 1;
                }
                if(Integer.parseInt(inputRow[11])==0){
                    rowObj.ca= 0;
                }
                else  if(Integer.parseInt(inputRow[11])==1){
                    rowObj.ca= 1;
                }
                else  if(Integer.parseInt(inputRow[11])==2){
                    rowObj.ca= 2;
                }
                else  if(Integer.parseInt(inputRow[11])==3){
                    rowObj.ca= 3;
                }
               if(Integer.parseInt(inputRow[12])==3){
                    rowObj.thal= -1;
                }
                else  if(Integer.parseInt(inputRow[12])==6){
                    rowObj.thal= 0;
                }
               else  if(Integer.parseInt(inputRow[12])==7){
                    rowObj.thal= 1;
                }
            else if(Integer.parseInt(inputRow[12])==3){
                    rowObj.thal= -1;
                }
                 if(inputRow[13].equalsIgnoreCase("zero")){
                     rowObj.clas =0;
                 }
                 else if(inputRow[13].equalsIgnoreCase("one")){
                     rowObj.clas =1;
                 }
                inputLayer.add(rowObj);
               // int count = inputLayer.size();
	//System.out.println("Count: " + count);
                 //System.out.println("rowObj" + rowObj);
            }
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Readed" + "\t" + inputLayer.size() + "\t" + "records");
        
        
        //printing
        /*
        Iterator<values> arIterator = inputLayer.iterator();
        while (arIterator.hasNext()) {
            values values =arIterator.next();
            System.out.println(""+values.age+","+values.sex+","+values.cp+","+values.restbps+","+values.chol+","+values.fbs+","+values.restecg+","+values.thalach+","+values.exang+","+values.oldpeak+","+values.slope+","+values.ca+","+values.thal+","+values.clas+"");
        }
        */
        return inputLayer;
        
    }
    
}
