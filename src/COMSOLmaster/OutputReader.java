/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMSOLmaster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.abs;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Pedro Anchieta
 */
public class OutputReader {
    
    private List<Double> x_val = new ArrayList<>();
    private List<Double> y_val = new ArrayList<>();
    private List<Double> mass_Xcd = new ArrayList<>();
    private List<Double> mass_Xst = new ArrayList<>();
    private List<Double> pressure = new ArrayList<>();
    
    
public OutputReader (String path) throws IOException
{
        try{

    BufferedReader br = new BufferedReader(new FileReader(path));
    String strLine;
    
    
    for (int i=1;i<=9;i++)
        br.readLine();
    //Skip file header
    
    while ((strLine = br.readLine()) != null)   
        //Read File Line By Line
    {
      Scanner sc = new Scanner(strLine);
      x_val.add(sc.nextDouble());
      y_val.add(sc.nextDouble());
      mass_Xcd.add(abs(sc.nextDouble()));
      mass_Xst.add(sc.nextDouble());
      //pressure.add(sc.nextDouble());
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

public List<Double> getMass_Xcd()
{
    return mass_Xcd;
}
public List<Double> getMass_Xst()
{
    return mass_Xst;
}
public double avgMass()
{
    double count=0.0f, count2=0.0f, avg1, avg2;
    
    for (int i = 0; i< mass_Xcd.size(); i++)
    {
        count += mass_Xcd.get(i);
        count2 += mass_Xst.get(i);      
    }
         
    avg1 = count/(mass_Xcd.size());
    avg2 = count2/(mass_Xst.size());
    
    //System.out.println(avg);
    return (avg1+avg2)/2;
}

public double avgMassXcd()
{
    double count=0.0f, avg;
    
    for (int i = 0; i< mass_Xcd.size(); i++)
        count = count + mass_Xcd.get(i);
    avg = count/mass_Xcd.size();
    //System.out.println(avg);
    return avg;
}

public double outletMass() 
{
   int a, i; 
   double mass_xcd = 0;
   double mass_xst = 0;
   
   for (i=0;i<5;i++)
   {
        a = x_val.indexOf(Collections.max(x_val));
        mass_xcd += mass_Xcd.get(a);
        mass_xst += mass_Xst.get(a);
        x_val.remove(a);
        y_val.remove(a);
        mass_Xcd.remove(a);
        mass_Xst.remove(a);
   }
   
   return ((mass_xcd/5)+(mass_xst/5)); 
}
        

public List<Double> getPressure ()
{
    return pressure;
}

public void printResults ()
{
    System.out.println(mass_Xcd);
    System.out.println(pressure);
}
    
}
