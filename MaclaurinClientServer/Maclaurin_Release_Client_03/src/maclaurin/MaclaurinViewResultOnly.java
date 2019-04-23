package maclaurin;

/**
 * View implementation of MVC pattern.
 * Displays data.
 * 
 * @author Bartosz Borys
 * @version 3.0
 */

public class MaclaurinViewResultOnly{
    
    /**
     * Updates view (console).
     * 
     * @param result Object which representing
     */
    
    public void update(final Object result){
        System.out.println( result.toString() );
    }
    
}
