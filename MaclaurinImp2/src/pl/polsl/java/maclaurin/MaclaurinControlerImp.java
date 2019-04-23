package pl.polsl.java.maclaurin;

import java.util.Vector;
import pl.polsl.java.maclaurin.working.MaclaurinInputParametersReader;
import pl.polsl.java.maclaurin.working.MaclaurinUserSeter;

/**
 * Transports data from model to view.
 * 
 * @author Bartosz Borys
 * @version 2.0
 */

public class MaclaurinControlerImp {
    private MaclaurinModelImp Model;
    private MaclaurinViewResultOnly View;
    
    /**
     * Constructor set Model and View.
     * 
     * @param Model Model of MVC pattern.
     * @param View View of MVC pattern.
     */
    public MaclaurinControlerImp(final MaclaurinModelImp Model, final MaclaurinViewResultOnly View){
        this.setModel(Model);
        this.setView(View);
    }
      
    /**
     * Method sets MVC Model data. If there is any Exception while reading parameters
     * then User is forced to set Model data by yourself.
     * @param ParametersReader Object which reading needed parameters;
     */
    
    public void setModelWithParameters(final MaclaurinInputParametersReader ParametersReader){
        try {
            this.setModelAccuracy( ParametersReader.getAccuracy() );
            this.setModelArgument( ParametersReader.getArgument() );
        }catch(Exception e) {
            System.out.println("ERROR:\n" + e.getMessage() + "\nSomething went wrong durning parameters load.\nPlease enter data by yourself.\n");
            this.userSetData();
        }
    }
    
    /**
     * Method sets Controller Model object.
     * 
     * @param Model MVC Model representation.
     */
    public final void setModel(final MaclaurinModelImp Model){
        this.Model = Model;
    }
    
    /**
     * Method sets Controller View object.
     * 
     * @param View MVC View representation.
     */
    
    public final void setView(final MaclaurinViewResultOnly View){
        this.View = View;
    }
    
    /**
     * Sets algoritm accuracy
     * 
     * @param accuracy accuracy value
     * @throws Exception there would be an exception while user sets Accuracu below 0
     */
    
    public void setModelAccuracy(int accuracy) throws Exception{
        this.Model.setAccuracy(accuracy);
    }
    
    /**
     * Sets algoritm argument
     * @deprecated User should use updateViewManyResults() and setModelArguments()
     * @param argument argument value
     */
    
    public void setModelArgument(double argument){
        this.Model.setArgument(argument);
    }
    
    /**
     * Sets algoritm arguments
     * 
     * @param arguments arguments values
     */
    
    public void setModelArguments(double...arguments){
        this.Model.setManyArguments(arguments);
    }
    
    /**
     * Mehtod updates view
     * @deprecated User should use updateViewManyResults() and setModelArguments()
     * @throws Exception throwing exception if result value is below 0 (impossible result for e^x function)
     */
    
    public void updateView() throws Exception{
        this.View.update( Model.getResult() );
    }
    
    /**
     * Mehtod updates view for many results
     * 
     * @throws Exception throwing exception if result value is below 0 (impossible result for e^x function)
     */
    
    public void updateViewManyResults() throws Exception{
        Vector<Double> results = this.Model.getManyResults();
        StringBuilder outputString = new StringBuilder("\n");
        Integer counter = 0;
        
        for(Double element : results){
            outputString.append("[").append(counter.toString()).append("] ");
            outputString.append( element.toString() );
            outputString.append("\n");
            counter++;
        }
        
        this.View.update( outputString );
    }
    
    /**
     * Sets Model data. When input is invalid then User has to repeat action until value is correct.
     */
    
    private void userSetData(){
        try{
            MaclaurinUserSeter UserInput = new MaclaurinUserSeter();
            this.setModelAccuracy( UserInput.readAccuracy() );
            this.setModelArgument( UserInput.readArgument() );
        }catch(Exception e){
            System.out.println("ERROR: Variable wrong type.\nPlease enter data again.\n");
            this.userSetData();
        }
    }
}