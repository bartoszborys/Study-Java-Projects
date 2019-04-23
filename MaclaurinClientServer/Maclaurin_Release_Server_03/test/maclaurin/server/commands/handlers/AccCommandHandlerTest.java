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
public class AccCommandHandlerTest {
    
    public AccCommandHandlerTest() {
    }

    /**
     * Test of handle method, of class AccCommandHandler.
     */
    @Test
    public void testHandle() throws Exception {
        MaclaurinModelEdit modelFake = new MaclaurinModelEditFake();
        ClientConnection connectionFake = new ClientConnectionFake();

        AccCommandHandler instance = new AccCommandHandler(connectionFake, "5", modelFake);
        instance.handle();
        int resultValue = ((MaclaurinModelEditFake)modelFake).accuracy;
        int expectedResultValue = 5;
        
        assertEquals(resultValue, expectedResultValue);
        
        
        String resultClientText = ((ClientConnectionFake)connectionFake).getClientMessageResult();
        String expectedResult = "DONE: Accuracy is set";
        
        assertEquals(resultClientText, expectedResult);
        
    }
    
}
