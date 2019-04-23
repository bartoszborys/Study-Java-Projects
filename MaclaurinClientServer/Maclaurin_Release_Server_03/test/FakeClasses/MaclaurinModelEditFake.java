/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FakeClasses;

import java.util.Vector;
import maclaurin.MaclaurinModelEdit;

/**
 *
 * @author Bartek
 */
public class MaclaurinModelEditFake implements MaclaurinModelEdit{
    
    public Vector<Double> arguments;
    public int accuracy;
    
    @Override
    public void setManyArguments(double... arguments) {
    }

    @Override
    public void setManyArguments(Vector<Double> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void setAccuracy(int accuracy) throws Exception {
        this.accuracy = accuracy;
    }
    
}
