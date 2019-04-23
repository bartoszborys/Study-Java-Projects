/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin;

import java.util.Vector;

/**
 * User can only get results throught this interface.
 * 
 * @author Bartek
 * @version 3.0
 */
public interface MaclaurinModelExecution {
    public Vector<Double> getManyResults() throws Exception;
}
