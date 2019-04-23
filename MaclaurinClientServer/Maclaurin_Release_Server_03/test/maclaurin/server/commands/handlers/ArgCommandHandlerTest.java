/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers;

import FakeClasses.ClientConnectionFake;
import FakeClasses.MaclaurinModelEditFake;
import java.util.Vector;
import maclaurin.MaclaurinModelEdit;
import maclaurin.server.bridge.ClientConnection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bartek
 */
public class ArgCommandHandlerTest {
    
    public ArgCommandHandlerTest() {
    }

    /**
     * Test of handle method, of class ArgCommandHandler.
     */
    @Test
    public void testHandle() throws Exception {
        MaclaurinModelEdit modelFake = new MaclaurinModelEditFake();
        ClientConnection connectionFake = new ClientConnectionFake();

        ArgCommandHandler instance = new ArgCommandHandler(connectionFake, "1,2,3,4", modelFake);
        instance.handle();
        Vector<Double> resultValue = ((MaclaurinModelEditFake)modelFake).arguments;
        Vector<Double> expectedResultValue = new Vector<Double>();
        expectedResultValue.add(1.0);
        expectedResultValue.add(2.0);
        expectedResultValue.add(3.0);
        expectedResultValue.add(4.0);
        
        assertEquals(resultValue, expectedResultValue);
        
        
        String resultClientText = ((ClientConnectionFake)connectionFake).getClientMessageResult();
        String expectedResult = "DONE: Arguments are set";
        
        assertEquals(resultClientText, expectedResult);
    }
    
}
