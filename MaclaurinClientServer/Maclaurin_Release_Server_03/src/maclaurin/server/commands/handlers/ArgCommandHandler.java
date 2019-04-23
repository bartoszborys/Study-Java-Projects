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
 * Handles ARG protocol command
 * 
 * @author Bartek
 * @version 3.0
 */
public class ArgCommandHandler implements CommandHandler {
    
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
    public ArgCommandHandler(ClientConnection client, String message, MaclaurinModelEdit serverLogicModel) {
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
            Vector<Double> arguments = argParameterRecivedCase(messageToHandle);
            serverLogicModel.setManyArguments(arguments);
            client.sendToClient("DONE: Arguments are set");
            log("GOOD: ARG protocol command handled");
        } catch (NumberFormatException e) {
            client.sendToClient("ERROR: Wrong parameters format after ARG command.");
        }
    }
    
    /**
     * parse string to double
     * 
     * @param dataFromClient data to parse
     * @return returns parsed values
     */
    private Vector<Double> argParameterRecivedCase(final String dataFromClient) {
        String[] args = dataFromClient.split(",");
        Vector<Double> arguments = new Vector<Double>();

        for (String argument : args) {
            arguments.add(Double.parseDouble(argument));
        }

        return arguments;
    }
}
