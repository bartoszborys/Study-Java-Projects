/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin;

import java.util.Vector;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bartek
 */
public class MaclaurinModelImpTest {
    
    public MaclaurinModelImpTest() {
    }

    /**
     * Test of setAccuracy method, of class MaclaurinModelImp.
     */
    @Test
    public void testSetAccuracyLowerThanZero() throws Exception {
        int accuracy = -1;
        MaclaurinModelImp instance = new MaclaurinModelImp();
        
        try{
            instance.setAccuracy(accuracy);
            fail("Method should throw exception");
        }catch(Exception e){
        }
    }
    
    @Test
    public void testSetAccuracyNormal() throws Exception {
        int accuracy = 20;
        MaclaurinModelImp instance = new MaclaurinModelImp();
        
        try{
            instance.setAccuracy(accuracy);
        }catch(Exception e){
            fail("Method shouldn't throw exception");
        }
    }
    
    /**
     * Test of getManyResults method, of class MaclaurinModelImp.
     */
    @Test
    public void testGetManyResults() throws Exception {
        MaclaurinModelImp instance = new MaclaurinModelImp();
        instance.setAccuracy(20);
        instance.setManyArguments(3,4);
        
        Vector<Double> expResult = new Vector<Double>();
        expResult.add(20.085536922950844);
        expResult.add(54.598149928148814);
        
        Vector<Double> result = instance.getManyResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of getResult method, of class MaclaurinModelImp.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetResult() throws Exception {
        MaclaurinModelImp instance = new MaclaurinModelImp();
        
        Vector<Double> arguments = new Vector<Double>();
        arguments.add(1.0);
        arguments.add(2.0);
        instance.setAccuracy(20);
        instance.setManyArguments(arguments);
        Vector<Double> result = instance.getManyResults();
        
        
        Vector<Double> expResult = new Vector<Double>();
        expResult.add(2.7182818284590455);
        expResult.add(7.389056098930604);
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getResult method, of class MaclaurinModelImp.
     */
    @Test
    public void testGetWrongResult() throws Exception {
        MaclaurinModelImp instance = new MaclaurinModelImp();
        
        instance.setAccuracy(29);
        Vector<Double> arguments = new Vector<Double>();
        arguments.add(10.0);
        arguments.add(20.0);
        instance.setManyArguments(arguments);
        
        try{
            Vector<Double> result = instance.getManyResults();
            fail("Method should throw exception");
        }catch(Exception e){
        }
        // TODO review the generated test code and remove the default call to fail.
    }
}
