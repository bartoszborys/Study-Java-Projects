/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers;

import FakeClasses.ClientConnectionFake;
import maclaurin.server.bridge.ClientConnection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bartek
 */
public class UnknownCommandHandlerTest {
    
    public UnknownCommandHandlerTest() {
    }

    /**
     * Test of handle method, of class UnknownCommandHandler.
     */
    @Test
    public void testHandle() throws Exception {
        ClientConnection connectionFake = new ClientConnectionFake();
        UnknownCommandHandler instance = new UnknownCommandHandler(connectionFake);
        instance.handle();
        
        String result = ((ClientConnectionFake)connectionFake).getClientMessageResult();
        String expectedResult = "Unknown Parameter, please use HELP command for more details.";
        
        assertEquals(result, expectedResult);
    }
    
}
