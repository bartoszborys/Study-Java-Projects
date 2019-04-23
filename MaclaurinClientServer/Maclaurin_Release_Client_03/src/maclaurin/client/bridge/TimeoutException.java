/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.client.bridge;

/**
 * Timeout exception
 * 
 * @author Bartek
 * @version 3.0
 */
public class TimeoutException extends Exception {
    
    /**
     * Exception with additional details
     * @param additionalInformation  additional details
     */
    public TimeoutException(String additionalInformation){
        super("ERROR: Timeout reached. " + additionalInformation);
    }
    
    /**
     * Exception without additional details
     */
    public TimeoutException(){
        super("ERROR: Unknown timeout reached");
    }
}
