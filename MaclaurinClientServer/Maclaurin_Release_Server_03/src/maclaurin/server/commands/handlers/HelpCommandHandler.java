/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers;

import java.io.IOException;
import java.util.Vector;
import maclaurin.server.bridge.ClientConnection;
import static maclaurin.server.bridge.MaclaurinServerController.log;

/**
 * Handles HELP protocol command
 * 
 * @author Bartek
 * @version 3.0
 */
public class HelpCommandHandler implements CommandHandler {
    /**
     * @param messageToHandle command parameters to handle
     * @param client client connection
     */
    private final String messageToHandle;
    private final ClientConnection client;
    
    /**
     * Sets basic parameters
     * 
     * @param client connection with Client
     * @param message message to handle
     */
    public HelpCommandHandler(ClientConnection client, String message) {
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
        if (messageToHandle.length() == 0) {
            helpParameterRecivedCase();
            return;
        }

        switch (messageToHandle.toUpperCase()) {

            case "ARG":
                argParameterHelpExplain();
                break;

            case "ACC":
                accParameterHelpExplain();
                break;

            case "EXE":
                exeParameterHelpExplain();
                break;

            case "EXT":
                extParameterHelpExplain();
                break;

            default:
                commandError();
                break;

        }

        log("GOOD: HELP protocol command handled");
    }
    
    /**
     * handles error parameter help command
     */
    private void commandError() {
        client.sendToClient("HELP command syntax error. Type HELP for command details.");
    }
    
    /**
     * handles exe parameter help command
     */
    private void exeParameterHelpExplain() {
        client.sendToClient("");
        client.sendToClient("Executing Maclaurin algorithm.");
        client.sendToClient("Accuracy and Arguments must be set.");
    }
    
    /**
     * handles acc parameter help command
     */
    private void accParameterHelpExplain() {
        client.sendToClient("");
        client.sendToClient("Sets accuracy for Maclaurin algorithm.");
        client.sendToClient("COMMAND SYNTAX:");
        client.sendToClient("ACC <VALUE>");
        client.sendToClient("");
        client.sendToClient("<VALUE> -> number equal or higher than zero.");
        client.sendToClient("EXAMPLE: ARG 1");
    }
    
    /**
     * handles arg parameter help command
     */

    private void argParameterHelpExplain() {
        client.sendToClient("");
        client.sendToClient("Sets arguments for Maclaurin algorithm.");
        client.sendToClient("COMMAND SYNTAX:");
        client.sendToClient("ARG <VALUES>");
        client.sendToClient("");
        client.sendToClient("<VALUES> -> separated by comma numbers ");
        client.sendToClient("EXAMPLE: ARG 1,2,3,4,5");
    }
    
    /**
     * handles ext parameter help command
     */

    private void extParameterHelpExplain() {
        client.sendToClient("Closing connection");
        client.sendToClient("Takes no parameters");
    }
    
    /**
     * handles help parameter help command
     */

    private void helpParameterRecivedCase() throws IOException {
        client.sendToClient("Avaible commands:");
        client.sendToClient("ARG - sets argument/arguments");
        client.sendToClient("ACC - sets accuaricy");
        client.sendToClient("EXE - execute algorithm");
        client.sendToClient("EXT - break connection");
        client.sendToClient("");
        client.sendToClient("Type HELP <COMMAND> for more details.");
    }
}
