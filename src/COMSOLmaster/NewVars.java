/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMSOLmaster;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Pedro Anchieta
 */
public class NewVars {
    
    private final String path;
    
    private float radius;
    private float x_dis;
    private float y_dis;
    
    public NewVars(String path)
    {
        this.path = path;
    }

    
    public void writeVars() throws FileNotFoundException, IOException
    {
    
    try(FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
    {
        out.println("Radius=" + String.valueOf(radius));
        out.println("X=" + String.valueOf(x_dis));
        out.println("Y=" + String.valueOf(y_dis) + "\n");
    }
    catch(IOException e)
    {
        System.err.println("IOException: " + e.getMessage());
    }
        
    }
    public void setX_dis(float x_dis)
    {
        this.x_dis=x_dis;
    }
    
    public void setY_dis(float y_dis)
    {
        this.y_dis=y_dis;
    }
    
    public void setRadius(float radius)
    {
        this.radius=radius;
    }
    
    public float getX_dis()
    {
        return this.x_dis;
    }
    
    public float getY_dis()
    {
        return this.y_dis;
    }
        
    public float getRadius()
    {
        return this.radius;
    }
    
    
    
}
