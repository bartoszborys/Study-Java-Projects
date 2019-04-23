/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.maclaurin;

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
        System.out.println("Set Accuracy");
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
        System.out.println("Set Accuracy");
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
        System.out.println("Get Many Results");
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
     */
    @Test
    public void testGetResult() throws Exception {
        System.out.println("Get Result");
        MaclaurinModelImp instance = new MaclaurinModelImp();
        
        instance.setAccuracy(20);
        instance.setArgument(4);
        
        double expResult = 54.598149928148814;
        double result = instance.getResult();
        
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getResult method, of class MaclaurinModelImp.
     */
    @Test
    public void testGetWrongResult() throws Exception {
        System.out.println("Get Result");
        MaclaurinModelImp instance = new MaclaurinModelImp();
        
        instance.setAccuracy(29);
        instance.setArgument(10);
        
        try{
            double result = instance.getResult();
            fail("Method should throw exception");
        }catch(Exception e){
        }
        // TODO review the generated test code and remove the default call to fail.
    }
}
