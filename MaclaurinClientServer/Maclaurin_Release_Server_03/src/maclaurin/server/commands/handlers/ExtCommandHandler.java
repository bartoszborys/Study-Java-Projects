/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers;

import java.io.IOException;
import maclaurin.MaclaurinModelImp;
import maclaurin.server.bridge.ClientConnection;
import static maclaurin.server.bridge.MaclaurinServerController.log;
import maclaurin.server.resources.TimeoutGuardian;

/**
 * Handles EXT protocol command
 * 
 * @author Bartek
 * @version 3.0
 */
public class ExtCommandHandler implements CommandHandler {
    /**
     * @param client client connection
     */
    private final ClientConnection client;
    
    /**
     * Sets basic parameters
     * 
     * @param client connection with Client
     */
    public ExtCommandHandler(ClientConnection client) {
        this.client = client;
    }

    /**
     * handles command logic
     * 
     * @throws IOException if there problems with connection
     */
    
    @Override
    public void handle() throws IOException {
        client.sendToClient("EXT_GOOD");
        client.sendToClient("\0");

        TimeoutGuardian guardian = new TimeoutGuardian();
        guardian.setTimeout(10);
        guardian.start();

        while (client.getConnecitonSocket().isClosed()) {
            if (guardian.checkTimeout()) {
                throw new IOException();
            }
        };

        log("GOOD: Connection close action handled.");
    }
}
