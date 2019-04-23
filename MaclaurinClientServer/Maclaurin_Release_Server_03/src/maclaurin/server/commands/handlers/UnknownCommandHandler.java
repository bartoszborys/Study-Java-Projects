/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers;

import java.io.IOException;
import maclaurin.server.bridge.ClientConnection;
import static maclaurin.server.bridge.MaclaurinServerController.log;

/**
 * Handles ACC protocol command
 * 
 * @author Bartek
 * @version 3.0
 */
public class UnknownCommandHandler implements CommandHandler {
    /**
     * @param client client connection
     */
    private final ClientConnection client;
    
    /**
     * Sets basic parameters
     * 
     * @param client connection with Client
     */
    
    public UnknownCommandHandler(ClientConnection client) {
        this.client = client;
    }

    /**
     * handles command logic
     * 
     * @throws IOException if there problems with connection
     */
    
    @Override
    public void handle() throws IOException {
        client.sendToClient("Unknown Parameter, please use HELP command for more details.");
        log("GOOD:  Unknown parameter handled.");
    }

}
