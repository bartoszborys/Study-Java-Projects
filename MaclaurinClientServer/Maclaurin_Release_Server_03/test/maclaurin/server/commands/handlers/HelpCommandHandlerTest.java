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
public class HelpCommandHandlerTest {
    
    public HelpCommandHandlerTest() {
    }

    /**
     * Test of handle method, of class HelpCommandHandler.
     */
    @Test
    public void testHandle() throws Exception {
        ClientConnection connectionFake = new ClientConnectionFake();
        HelpCommandHandler instance = new HelpCommandHandler(connectionFake, "");
        instance.handle();
        
        String result = ((ClientConnectionFake)connectionFake).getClientMessageResult();
        String ExpectedResult = "Avaible commands:ARG - sets argument/argumentsACC - sets accuaricyEXE - execute algorithmEXT - break connectionType HELP <COMMAND> for more details.";
        
        System.out.print(ExpectedResult);
        
        assertEquals(result, ExpectedResult);
    }
    
}
