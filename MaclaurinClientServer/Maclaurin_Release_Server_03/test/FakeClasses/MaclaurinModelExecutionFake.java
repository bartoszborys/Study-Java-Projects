/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FakeClasses;

import java.util.Vector;
import maclaurin.MaclaurinModelExecution;

/**
 *
 * @author Bartek
 */
public class MaclaurinModelExecutionFake implements MaclaurinModelExecution{
    public Vector<Double> results;
    @Override
    public Vector<Double> getManyResults() throws Exception {
        return results;
    }
    
}
