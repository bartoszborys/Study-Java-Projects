/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kielbaski.boro.test.Resources;

import java.util.Vector;

/**
 * Lets user take control over whole model.
 * 
 * @author Bartek
 * @version 3.0
 */
public interface MaclaurinModel {
    public void empty();
    public int getAccuracy();
    public double getArgument();
    public void setManyArguments(double... arguments);
    public void setManyArguments(Vector<Double> arguments);
    public Vector<Double> getManyResults() throws Exception;
    public void setAccuracy(final int accuracy) throws Exception;
}
