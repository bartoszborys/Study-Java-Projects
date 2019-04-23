/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers;

import FakeClasses.ClientConnectionFake;
import FakeClasses.MaclaurinModelExecutionFake;
import java.util.Vector;
import maclaurin.MaclaurinModelExecution;
import maclaurin.server.bridge.ClientConnection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bartek
 */
public class ExeCommandHandlerTest {
    
    public ExeCommandHandlerTest() {
    }

    /**
     * Test of handle method, of class ExeCommandHandler.
     */
    @Test
    public void testHandle() throws Exception {
        MaclaurinModelExecution modelFake = new MaclaurinModelExecutionFake();
        ClientConnection connectionFake = new ClientConnectionFake();
        
        Vector<Double> modelResultsFake = new Vector<Double>();
        modelResultsFake.add(1.0);
        modelResultsFake.add(2.0);
        modelResultsFake.add(3.0);
        
        ( (MaclaurinModelExecutionFake)modelFake ).results = modelResultsFake;
        
        
        ExeCommandHandler instance = new ExeCommandHandler(connectionFake, "", modelFake);
        instance.handle();
        
        String resultClientText = ((ClientConnectionFake)connectionFake).getClientMessageResult();
        String expectedResult = "Result: [0]   1.0\n" +
                                "[1]   2.0\n" +
                                "[2]   3.0\n";
        
        assertEquals(resultClientText, expectedResult);
    }
    
}
