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
public class ExtCommandHandlerTest {
    
    public ExtCommandHandlerTest() {
    }

    /**
     * Test of handle method, of class ExtCommandHandler.
     */
    @Test
    public void testHandle() throws Exception {
        ClientConnection connectionFake = new ClientConnectionFake();
       
        ExtCommandHandler instance = new ExtCommandHandler(connectionFake);
        instance.handle();
        
        String resultClientText = ((ClientConnectionFake)connectionFake).getClientMessageResult();
        String expectedResult = "EXT_GOOD\0";
        
        assertEquals(resultClientText, expectedResult);
    }
    
}
