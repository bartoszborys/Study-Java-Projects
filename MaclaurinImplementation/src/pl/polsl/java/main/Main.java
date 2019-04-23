package pl.polsl.java.main;

import pl.polsl.java.maclaurin.MaclaurinControlerImp;
import pl.polsl.java.maclaurin.working.MaclaurinInputParametersReader;
import pl.polsl.java.maclaurin.MaclaurinModelImp;
import pl.polsl.java.maclaurin.MaclaurinViewResultOnly;

/**
 * Main program Class.
 * Displays data.
 * 
 * @author Bartosz Borys
 * @version 1.0
 */

public class Main {

    /**
     * Main method
     * 
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here        
        MaclaurinModelImp Model = new MaclaurinModelImp();
        MaclaurinViewResultOnly View = new MaclaurinViewResultOnly();
        MaclaurinInputParametersReader ParametersReader = new MaclaurinInputParametersReader( args );
        
        try {
            MaclaurinControlerImp Controler = new MaclaurinControlerImp(Model, View);
            Controler.setModelWithParameters( ParametersReader );
            Controler.updateView();
        } catch (Exception e) {
            System.out.println( e.getMessage() );
            System.out.println("Program failed while executing.");
        }
    }
}
