/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers;

import java.io.IOException;
import java.util.Vector;
import maclaurin.MaclaurinModelExecution;
import maclaurin.MaclaurinModelImp;
import maclaurin.server.bridge.ClientConnection;
import static maclaurin.server.bridge.MaclaurinServerController.log;

/**
 * Handles EXE protocol command
 * 
 * @author Bartek
 * @version 3.0
 */
public class ExeCommandHandler implements CommandHandler {
    /**
     * @param messageToHandle command parameters to handle
     * @param client client connection
     * @param serverLogicModel interface which provides edit model possibility
     */
    private final String messageToHandle;
    private final ClientConnection client;
    private final MaclaurinModelExecution serverLogicModel;
    
    /**
     * Sets basic parameters
     * 
     * @param client connection with Client
     * @param message message to handle
     * @param serverLogicModel interface which provides model execute
     */
    public ExeCommandHandler(ClientConnection client, String message, MaclaurinModelExecution serverLogicModel) {
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
            if (!messageToHandle.isEmpty()) {
                client.sendToClient("ERROR: Wrong command syntax. Type help for command details");
                return;
            }

            Vector<Double> results = serverLogicModel.getManyResults();
            StringBuilder everything = new StringBuilder();

            everything.append("Result: ");
            for (Double result : results) {
                Integer index = results.indexOf(result);
                everything.append("[" + index.toString() + "]" + "   " + result.toString() + "\n");
            }

            client.sendToClient(everything.toString());
        } catch (Exception e) {
            log(e.getMessage());
            client.sendToClient(e.getMessage());
        }
    }

}
