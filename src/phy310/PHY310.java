/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phy310;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ptolemy.plot.Plot;
import ptolemy.plot.PlotApplication;



/**
 *
 * @author dmkaliel
 */
public class PHY310 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        DecimalFormat df = new DecimalFormat("#.##");
        double[] var = new double[10];   
        int viLoc = 0;
        int angleLoc = 2;
        int yiLoc = 1;
        int timestepLoc = 3;
        int rotationLoc = 4;
        
        
        //Volleyball
        /*
        double k = .5*1.2*.03*.5;  //C*airdensity*area*.5
        double mass = .3;
        double Km = .0006578;      
        */
        
        
        //TableTennis
        /*
         double k = .5*1.2*.001*.5;
         double mass = .0027;
         double Km = .000207;
         /*
        
        //Baseball
        /*
         double k = .5*1.2*.017*.5;
         double mass = .15;
         double Km = .00006;
     */
        
        
        //Bowling
        
        double k = .5*1.2*.04*.5;
        double mass = 7.26;
        double Km = .0001;
        
        
        
        //Reading and initailizing the variables
        
        java.io.File file = new java.io.File("PHY310input.txt");
        try 
        {
            Scanner input = new Scanner(file);
            int i = 0;
            while (input.hasNext())
            {   
                   String line = input.nextLine();
                   String delims = "[ ]+";
                   String[] tokens = line.split(delims);
                   var[i] = Double.parseDouble(tokens[1]); 
                   i++;
            }    
        } 
        
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(PHY310.class.getName()).log(Level.SEVERE, null, ex);
        }
        double angle = var[angleLoc]*2*Math.PI/360;
        double viy = var[viLoc]*Math.sin(angle);
        double vix = var[viLoc]*Math.cos(angle);
        double vy = viy;
        double vx = vix;
        double timestep = var[timestepLoc];
        double g = 9.8;
        double yi = var[yiLoc];
        double y = yi;
        double x = 0;
        double w = var[rotationLoc]*2*Math.PI;

        


        int i = 0;
        
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("PHY310output.txt", false)))) 
        {   
            
            
            while (y >= 0)
            { 
                out.println(y + "        " + x);
                
                
                vy = vy - g*timestep;
                y = y + vy*timestep;
                x = x + vx*timestep;
                
                
                i++;  
            }

        }
        
        catch (IOException e) 
        {
            
        }
        //printing set 2
        
        double finalvelocitywithout = Math.sqrt(vx*vx+vy*vy);
        
        //double angle2 = var[angleLoc+4]*2*Math.PI/360;
        //viy = var[viLoc+4]*Math.sin(angle2);
        //vix = var[viLoc+4]*Math.cos(angle2);
        vy = viy;
        vx = vix;
        //timestep = var[timestepLoc+4];
        g = 10;
        //yi = var[yiLoc+4];
        y = yi;
        x = 0;
        i = 0;
        double Fa = 0;
        double v = 0;
        double Fay = 0;
        double Fax = 0;
        double ay = 0;
        double ax = 0;
        

        try(PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("PHY310output2.txt", false)))) 
        {   
            while (y >= 0)
            {   
                out2.println(y + "        " + x);
                
                v = Math.sqrt(vx*vx + vy*vy);
                
                Fay = -Fa*vy/v;
                ay = -g + Fay/mass;
                vy = vy+ay*timestep;
                
                
                Fa = k*v*v;
                Fax = -Fa*vx/v;
                ax = Fax/mass;
                //System.out.println(df.format(R) + ",        " + df.format(v) + "      " + df.format(ry) + "      " + df.format(rx) );
                
                vx = vx+ax*timestep;
                y = y+vy*timestep;
                x = x+vx*timestep;
                i++; 
            }
        }
        
        catch (IOException e) 
        {
            
        }
        
        
        //printing to ouput file 3
        
        vy = viy;
        vx = vix;
        //timestep = var[timestepLoc+4];
        g = 10;
        //yi = var[yiLoc+4];
        y = yi;
        x = 0;
        i = 0;
        Fa = 0;
        double Fm = 0;
        v = 0;
        Fay = 0;
        Fax = 0;
        double Fmx = 0;
        double Fmy = 0;
        ay = 0;
        ax = 0;


        try(PrintWriter out3 = new PrintWriter(new BufferedWriter(new FileWriter("PHY310output3.txt", false)))) 
        {   
            while (y >= 0)
            {   
                out3.println(y + "        " + x);
                
                v = Math.sqrt(vx*vx+vy*vy);
                
                Fa = k*v*v;
                Fay = -Fa*vy/v;
                Fax = -Fa*vx/v;
                
                Fm = Km*w*v;
                Fmx = Fm*vy/v;
                ax = (Fax+Fmx)/mass;
                
                Fmy = -Fm*vx/v;               
                ay = -g+(Fay+Fmy)/mass;
                
                
               
                
               
                //System.out.println(df.format(R) + ",        " + df.format(v) + "      " + df.format(ry) + "      " + df.format(rx) );
                vy = vy+ay*timestep;
                vx = vx+ax*timestep;
                y = y+vy*timestep;
                x = x+vx*timestep;
                i++; 
            }
        }
        
        catch (IOException e) 
        {
            
        }

    double distancewith = 0;
    double distancewithout = 0;
    double heightwith = 0;    
    double heightwithout = 0;
    double timestepswith = 0;
    double timestepswithout = 0;
        
    Plot myPlot = new Plot();

    myPlot.setTitle("Motion of Projectile");
    myPlot.setXLabel("x (m)");
    myPlot.setYLabel("y");
    //myPlot.addLegend(1, "Without resistance");
    myPlot.addLegend(2, "With resistance");
    myPlot.addLegend(3, "With resistance and Magnus effect");
    //myPlot.zoom(0, 5, 0, 5);
    //myPlot.setXRange(0., 15.);
    //myPlot.setYRange(0., 15.);
    
        java.io.File output1 = new java.io.File("PHY310output.txt");
        java.io.File output2 = new java.io.File("PHY310output2.txt");
        java.io.File output3 = new java.io.File("PHY310output3.txt");
        try 
        {
            Scanner input = new Scanner(output1);
            
            
           while(input.hasNext())
            {   
                String next = input.nextLine(); 
                String delims = "[ ]+";
                String[] data = next.split(delims);
                double py = Double.parseDouble(data[0]); 
                double px = Double.parseDouble(data[1]);                      
                //double by = px*Math.tan(angle)-g*px*px/(2*var[viLoc]*var[viLoc]*Math.cos(angle)*Math.cos(angle))+yi;
                //myPlot.addPoint(1, px, py, true);
                //myPlot.addPoint(0, px, by, true);  
                if (py > heightwithout)
                {
                    heightwithout = py;
                }
                distancewithout = px;
                timestepswithout++;
            }    
           
             Scanner input2 = new Scanner(output2);
             
            while(input2.hasNext())
            {   
                String next = input2.nextLine(); 
                String delims = "[ ]+";
                String[] data = next.split(delims);
                double py = Double.parseDouble(data[0]); 
                double px = Double.parseDouble(data[1]);                      
                //double by = ax*Math.tan(angle)-g*ax*ax/(2*var[viLoc]*var[viLoc]*Math.cos(angle)*Math.cos(angle))+yi;
                myPlot.addPoint(2, px, py, true);
                //myPlot.addPoint(3, ax, by, true);   
                if (py > heightwith)
                {
                    heightwith = py;
                }
                distancewith = px;
                timestepswith++;
            }   
                       
             Scanner input3 = new Scanner(output3);
             
            while(input3.hasNext())
            {   
                String next = input3.nextLine(); 
                String delims = "[ ]+";
                String[] data = next.split(delims);
                double py = Double.parseDouble(data[0]); 
                double px = Double.parseDouble(data[1]);                      
                //double by = ax*Math.tan(angle)-g*ax*ax/(2*var[viLoc]*var[viLoc]*Math.cos(angle)*Math.cos(angle))+yi;
                myPlot.addPoint(3, px, py, true);
                //myPlot.addPoint(3, ax, by, true);   

            }   
        } 
        
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(PHY310.class.getName()).log(Level.SEVERE, null, ex);
        }
        //myPlot.addPoint(5, 9, 2.43,true);
        //myPlot.addPoint(5, 9, 1.5,true);
        
        
        
    
 System.out.println("Without Air Resistance: Horizontal = " + distancewithout + "m   Vertical = " + heightwithout + "m      Time = " + df.format(timestepswithout*timestep) + "s" + "   Final Velocity:   " + finalvelocitywithout);
System.out.println("With Air Resistance: Horizontal = " + distancewith + "m   Vertical = " + heightwith + "m      Time = " + df.format(timestepswith*timestep) + "s" + "   Final Velocity:    " + Math.sqrt(vy*vy+vx*vx));

 // Create PlotApplication to display Plot object
 PlotApplication app = new PlotApplication(myPlot);  
    }
}
