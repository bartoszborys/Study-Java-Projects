package pl.polsl.java.maclaurin.working;

import java.util.Arrays;

/**
 * Read needed parameters for the Maclaurin algorithm.
 * 
 * @author Bartosz Borys
 * @version 1.0
 */

public class MaclaurinInputParametersReader {
    
    private String[] programParameters;
    
    /**
     * Sets parameters member.
     * 
     * @param programParameters command line parameters
     */
    
    public MaclaurinInputParametersReader(String[] programParameters){
        this.programParameters = programParameters;
    }
    
    /**
     * returns argument parameter value
     * 
     * @return double value, argument parameter value
     */
    
    public double getArgument(){
        String ArgumentParameter = this.getParameter("-x");
        return Double.parseDouble(ArgumentParameter);
    }
    
    /**
     * returns accuracy parameter value
     * 
     * @return int value, accuracy parameter value
     */
    
    public int getAccuracy(){
        String AccuracyParameter = this.getParameter("-a");
        return Integer.parseInt(AccuracyParameter);        
    }
    
    /**
     * returns index of switch value
     * 
     * @param ParameterSwitch search given switch
     * @return int value, index of switch value
     */
    
    private int getIndexOfParameter(final String ParameterSwitch){
        return Arrays.asList(programParameters).indexOf(ParameterSwitch) + 1;
    }
    
    /**
     * returns value of given switch
     * 
     * @param ParameterSwitch search given switch
     * @return string value, value of given switch
     */
    
    private String getParameter(final String ParameterSwitch){
        return programParameters[ getIndexOfParameter(ParameterSwitch) ];
    }
}