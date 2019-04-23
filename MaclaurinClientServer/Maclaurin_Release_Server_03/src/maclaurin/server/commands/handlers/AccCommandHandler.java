/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers;

import java.io.IOException;
import java.util.Vector;
import maclaurin.MaclaurinModelEdit;
import maclaurin.server.bridge.ClientConnection;
import static maclaurin.server.bridge.MaclaurinServerController.log;

/**
 * Handles ACC protocol command
 * 
 * @author Bartek
 * @version 3.0
 */
public class AccCommandHandler implements CommandHandler {
    
    /**
     * @param messageToHandle command parameters to handle
     * @param client client connection
     * @param serverLogicModel interface which provides edit model possibility
     */
    private final String messageToHandle;
    private final ClientConnection client;
    private final MaclaurinModelEdit serverLogicModel;
    
    /**
     * Sets basic parameters
     * 
     * @param client connection with Client
     * @param message message to handle
     * @param serverLogicModel interface which provides model edit
     */
    public AccCommandHandler(ClientConnection client, String message, MaclaurinModelEdit serverLogicModel) {
        this.serverLogicModel = serverLogicModel;
        this.messageToHandle = message;
        this.client = client;
    }

    /**
     * handles command logic
     * 
     * @throws IOException if there problems with connection
     */
    
    @Override
    public void handle() throws IOException {
        try {
            int accuracy = Integer.parseInt(messageToHandle);
            serverLogicModel.setAccuracy(accuracy);
            client.sendToClient("DONE: Accuracy is set");
            log("GOOD: ACC protocol command handled");
        } catch (NumberFormatException e) {
            client.sendToClient("ERROR: Wrong parameters format after ACC command.");
        } catch (Exception e) {
            log(e.getMessage());
            client.sendToClient(e.getMessage());
        }
    }
}
