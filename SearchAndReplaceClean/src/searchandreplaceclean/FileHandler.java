/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchandreplaceclean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Kenneth Haahr
 */
public class FileHandler {
    
//Method to load file and turn it into string    
    public String readFile(File inFile){
        StringBuilder sb=new StringBuilder();
        Scanner in=null;
        try{
            in= new Scanner(inFile);
            while(in.hasNext()){
                sb.append(in.nextLine()+ "\n");
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }finally{
            in.close();
        }
        return sb.toString();        
    }
//Method to write text to file    
    public void writeFile(String txt, File outFile){
               // File I/O med brug af AutoCloaseble
        try (FileWriter fw = new FileWriter(outFile)) {
            fw.write(txt);
            fw.flush();// Write the buffer to the file
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
