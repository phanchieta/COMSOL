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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Pedro Anchieta
 */
public class ExternalPrograms {
    private final String file;
    private String log;
    private String classfile;
    
    public ExternalPrograms (String file, String log)
    {
        this.file=file;
        this.log=log;
        classfile = file;
        classfile = classfile.replace(".java", ".class");
    }
    void init () throws IOException /*Uses COMSOL Compiler to compile Java model file*/
    {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + System.getProperty("user.dir"));
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        
        while (true) 
        {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
        
        System.out.println ("Compiling " + file + " COMSOL Java model");
        builder.command("cmd.exe", "/c", "comsolcompile " + file);
        builder.start();
        p = builder.start();
        
        r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        
        while (true) 
        {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }

        System.out.println("Done.");
        
    }
    
    void run(String radius, String x, String y) throws IOException
    {
        init();
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + System.getProperty("user.dir"));
        Process p=builder.start();
        
        String line;
        
        System.out.println("Running COMSOL simulation");
        
        File fout = new File(log + ".txt");
	FileOutputStream fos = new FileOutputStream(fout);
        
        builder.command("cmd.exe", "/c", "comsolbatch -inputfile " + classfile + " \"%cd%\" " + radius + " " + x +" "+ y );
        p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) 
        {
            while (true) 
            {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            
            }
           bw.close();
        }
        catch(IOException e)
        {
            System.err.println("IOException: " + e.getMessage());
        }   
        
        LogHandler lh = new LogHandler (log + ".txt");
        if (lh.error()) //Handle error that was detected
        {
            System.out.println ("Error detected in COMSOL log file");
        
        }
                
        System.out.println("Done.");
    }
        
    public void loop(NewVars a) throws IOException
    {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + System.getProperty("user.dir"));
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        
        while (true) 
        {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
            for (int i=1;i<=2;i++)
        {
        System.out.println("Running COMSOL simulation");
        log = "log" + i;
        File fout = new File(log + ".txt");
	FileOutputStream fos = new FileOutputStream(fout);
        
        builder.command("cmd.exe", "/c", "comsolbatch -inputfile " + classfile + " \"%cd%\" " + a.getRadius() + " " + a.getX_dis() +" "+ a.getY_dis() );
        p = builder.start();
        r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) 
            {
                while (true) 
                {
                    line = r.readLine();
                    if (line == null) { break; }
                    System.out.println(line);
                    bw.write(line);
                    bw.newLine();
            
                }
           bw.close();
            }
        catch(IOException e)
        {
            System.err.println("IOException: " + e.getMessage());
        }
        
        LogHandler lh = new LogHandler (log + ".txt");
            if (lh.error()) //Handle error that was detected
            {
                System.out.println ("Error detected in COMSOL log file");
        
            }
            
        System.out.println("Done.");
        a.setRadius(0.15f);
        a.setX_dis(1.0f);
        a.setY_dis(0.2f);
        a.writeVars();
        }

        //run optimization routine
        //set new vars
            
            
    }
    public String getClassfile ()
    {
        return classfile;
    }
    
    public String getJavaFile()
    {
        return file;
    }
       
 }
    