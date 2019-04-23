/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.servelet.input;

import java.io.IOException;
import java.util.Vector;

/**
 * Handles ARG protocol command
 * 
 * @author Bartek
 * @version 4.0
 */
public class ArgumentParser {
    
    /**
     * @param messageToHandle command parameters to handle
     */
    private final String parameterValue;
    
    /**
     * Sets basic parameters
     * 
     * @param message message to handle
     */
    public ArgumentParser(String message) {
        this.parameterValue = message;
    }

    /**
     * handles command logic
     * 
     * @throws IOException if there problems with connection
     */
    public Vector<Double> parse() throws Exception{
        try {
            Vector<Double> arguments = argParameterRecivedCase(parameterValue);
            return arguments;
        } catch (NumberFormatException e) {
            throw new Exception("Arguments parameter is wrong!");
        }
    }
    
    /**
     * parse string to double
     * 
     * @param dataFromClient data to parse
     * @return returns parsed values
     */
    private Vector<Double> argParameterRecivedCase(final String dataFromClient) {
        String[] args = dataFromClient.split(",");
        Vector<Double> arguments = new Vector<Double>();

        for (String argument : args) {
            arguments.add(Double.parseDouble(argument));
        }

        return arguments;
    }
}
