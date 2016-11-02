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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Pedro Anchieta
 */
public class OutputReader {
    
    private List<Double> x_val = new ArrayList<>();
    private List<Double> y_val = new ArrayList<>();
    private List<Double> velocity_x = new ArrayList<>();
    private List<Double> velocity_y = new ArrayList<>();
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
      velocity_x.add(abs(sc.nextDouble()));
      velocity_y.add(abs(sc.nextDouble()));
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

public List<Double> getVelocityX()
{
    return velocity_x;
}
public List<Double> getVelocityY()
{
    return velocity_y;
}
public double avgSpeed()
{
    double count=0.0f, avg;
    
    for (int i = 0; i< velocity_x.size(); i++)
        count = count + velocity_x.get(i) + velocity_y.get(i);
    avg = count/(velocity_x.size() + velocity_y.size());
    //System.out.println(avg);
    return avg;
}

public List<Double> getPressure ()
{
    return pressure;
}

public void printResults ()
{
    System.out.println(velocity_x);
    System.out.println(pressure);
}
    
}
