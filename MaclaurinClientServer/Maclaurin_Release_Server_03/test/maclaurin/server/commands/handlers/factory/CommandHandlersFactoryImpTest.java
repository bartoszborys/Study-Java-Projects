/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers.factory;

import FakeClasses.ClientConnectionFake;
import FakeClasses.MaclaurinModelFake;
import java.io.IOException;
import maclaurin.server.resources.ActionResolverEnum;
import org.junit.Test;
import static org.junit.Assert.*;

import maclaurin.MaclaurinModelImp;
import maclaurin.server.commands.handlers.*;
import static maclaurin.server.resources.ActionResolverEnum.*;
import maclaurin.server.commands.handlers.CommandHandler;

/**
 *
 * @author Bartek
 */
public class CommandHandlersFactoryImpTest {

    private CommandHandlersFactoryImp factory;

    public CommandHandlersFactoryImpTest() throws IOException {
        factory = new CommandHandlersFactoryImp(new ClientConnectionFake(), "EMPTY STRING", new MaclaurinModelFake());
    }

    /**
     * Test of get method, of class CommandHandlersFactoryImp.
     * @throws java.io.IOException
     */
    @Test
    public void shouldGetAccHandler() throws IOException {
        CommandHandler ResultElement = factory.get(ACC);
        boolean result = ResultElement instanceof AccCommandHandler;
        boolean expectedResult = true;
        
        assertEquals(result, expectedResult);
    }
    
    @Test
    public void shouldGetArgHandler() throws IOException {
        CommandHandler ResultElement = factory.get(ARG);
        boolean result = ResultElement instanceof ArgCommandHandler;
        boolean expectedResult = true;
        
        assertEquals(result, expectedResult);
    }
    
    @Test
    public void shouldGetExeHandler() throws IOException {
        CommandHandler ResultElement = factory.get(EXE);
        boolean result = ResultElement instanceof ExeCommandHandler;
        boolean expectedResult = true;
        
        assertEquals(result, expectedResult);
    }
    
    @Test
    public void shouldGetExtHandler() throws IOException {
        CommandHandler ResultElement = factory.get(EXT);
        boolean result = ResultElement instanceof ExtCommandHandler;
        boolean expectedResult = true;
        
        assertEquals(result, expectedResult);
    }
    
    @Test
    public void shouldGetHelpHandler() throws IOException {
        CommandHandler ResultElement = factory.get(HELP);
        boolean result = ResultElement instanceof HelpCommandHandler;
        boolean expectedResult = true;
        
        assertEquals(result, expectedResult);
    }
    
    @Test
    public void shouldGetUnknownHandler() throws IOException {
        CommandHandler ResultElement = factory.get(UNKNOWN);
        boolean result = ResultElement instanceof UnknownCommandHandler;
        boolean expectedResult = true;
        
        assertEquals(result, expectedResult);
    }    

}
