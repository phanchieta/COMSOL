/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMSOLmaster;

import java.io.IOException;
import static java.lang.System.exit;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pedro Anchieta
 */
public class Main {
       /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        
        /*Date now = new Date();
        newVars nv = new newVars("vars " + new SimpleDateFormat("dd-MM-yyyy HH.mm").format(now) + ".txt");
        //or.printResults();
        
        externalPrograms ep = new externalPrograms(args[0], "log");
        ep.run("0", "0.1", "0.1");
        
                
        //run optimization routine and set new params
        
        System.out.println("Writing new parameters.");
        
        nv.setRadius(0.1f);
        nv.setX_dis(1);
        nv.setY_dis(0.1f);
        nv.writeVars();

        
        ep.loop(nv); //loop with new params
        */
        ExternalPrograms ep = new ExternalPrograms(args[0], "log");
        Optimizer op = new Optimizer();
        op.genetic(ep);
        
        exit(1);
      
    }
    
    
}
