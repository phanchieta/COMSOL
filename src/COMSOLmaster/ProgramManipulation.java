/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMSOLmaster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import static java.lang.System.in;
import java.util.Vector;


/**
 *
 * @author Pedro Anchieta
 */
public class ProgramManipulation {
    private Vector<String> program;
    private String path;
    
    public ProgramManipulation (String path) throws IOException
    {
        this.path = path;
        this.program = new Vector<>();
        try{

    BufferedReader br = new BufferedReader(new FileReader(path));
    String strLine;
    //for (int i=1;i<=9;i++)
        //br.readLine();
    //Skip n number of lines to desired program line
    
    while ((strLine = br.readLine()) != null)   
        //Read File Line By Line
    {
      //Scanner sc = new Scanner(strLine);
      program.add(strLine);
	  //Adding values to list
    }
    //Close the input stream
    in.close();  
    }
   catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
   finally{
     in.close();
    }
   
        
   }
    public void print ()
    {
        System.out.println(program);
    }
    
    public void modifier (int lineNumber, String command)
    {
        //Changes program lines
        program.remove(lineNumber-1);
        program.add(lineNumber-1, command);       
    
    }
    public void writeProgram () throws IOException
    {
        //Writes Java program to file
        
        File fout = new File(path);
	FileOutputStream fos = new FileOutputStream(fout);

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
            for (String program1 : program) {
                bw.write(program1);
                bw.newLine();
            }
        
            bw.close();
        }
        
        catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
        
    }
    
 }
    

