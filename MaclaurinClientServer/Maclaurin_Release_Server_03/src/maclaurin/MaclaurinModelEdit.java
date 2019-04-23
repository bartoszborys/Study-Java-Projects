/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin;

import java.util.Vector;

/**
 * User can only set model throught this interface.
 * 
 * @author Bartek
 * @version 3.0
 */
public interface MaclaurinModelEdit {
    public void setManyArguments(double... arguments);
    public void setManyArguments(Vector<Double> arguments);
    public void setAccuracy(final int accuracy) throws Exception;
}
