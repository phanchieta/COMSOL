/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMSOLmaster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Pedro Anchieta
 */
public class LogHandler {
    private List <String> log;
    
    public LogHandler (String path) throws IOException
    {
        this.log = new ArrayList <>();
        try{

    BufferedReader br = new BufferedReader(new FileReader(path));
    String strLine;
   
    while ((strLine = br.readLine()) != null)   
    {
      log.add(strLine);
    }
    //Close the input stream
    in.close();  
    }
   catch(IOException e)
    {
        System.err.println("IOException: " + e.getMessage());
    }
   finally{
     in.close();
    }
   
        
   }
    public boolean error()
    {
        return log.stream().anyMatch((log1) -> (log1.contains("Error")));
    }
    
}
