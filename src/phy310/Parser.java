/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phy310;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmkaliel
 */
public class Parser {
    public static void main(String[] args)
    {
        
        
        

        java.io.File file = new java.io.File("PHY310output.txt");
        try 
        {
            Scanner input = new Scanner(file);
            
            String phrase = input.nextLine();
            String delims = "[ ]+";
            String[] tokens = phrase.split(delims);
            System.out.println(tokens[0]);
            System.out.println(tokens[1]);
            phrase = input.nextLine();
            delims = "[ ]+";
            tokens = phrase.split(delims);
            System.out.println(tokens[0]);
            System.out.println(tokens[1]);
 
        } 
        
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(PHY310.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
}
