/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phy310;

/* EasyPtPlot.java by D.McI, C.B, RHL, 8/03 OSU
* Plot function using PtPlot package */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
 import ptolemy.plot.*; // Import plotting package.
 public class EasyPtPlot
 {
 //public static void main(String[] args)
 {
    Plot myPlot = new Plot();

    myPlot.setTitle("Height vs Time");
    myPlot.setXLabel("Time");
    myPlot.setYLabel("Height");
    // Add (x,cos(x)) data points to Plot object using addPoint

    
        java.io.File file = new java.io.File("PHY310output.txt");
        try 
        {
            Scanner input = new Scanner(file);
            
           double x = 0; 
           while(input.hasNext())
            {   double a = -5*x*x+150*x;
                double y = Double.parseDouble(input.nextLine());     
                myPlot.addPoint(0, x, y, true);
               // myPlot.addPoint(0, x, a, true);
                x = x + .1;
            }    
        } 
        
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(PHY310.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
 

 // Create PlotApplication to display Plot object
 PlotApplication app = new PlotApplication(myPlot);
 }
 }