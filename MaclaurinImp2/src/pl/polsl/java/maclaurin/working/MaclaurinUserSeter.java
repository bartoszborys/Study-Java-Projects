package pl.polsl.java.maclaurin.working;

import java.util.Scanner;

/**
 * Main program Class.
 * Displays data.
 * 
 * @author Bartosz Borys
 * @version 1.0
 */

public class MaclaurinUserSeter {
    
    private Scanner User = new Scanner(System.in);
    
    /**
     * Force user to set argument
     * 
     * @return User value
     */
    
    public double readArgument(){
        this.printMessage("Argument value (double) WITH COMMA!: ");
        return User.nextDouble();
    }
    
     /**
     * Force user to set argument
     * 
     * @return User value
     */
    
    public int readAccuracy(){
        this.printMessage("Accuracy value (int): ");
        return User.nextInt();
    }
    
    /**
     * Prints message on console.
     * 
     * @param Message Message to display
     */
    
    private void printMessage(String Message){
        System.out.println(Message);
    }
}
