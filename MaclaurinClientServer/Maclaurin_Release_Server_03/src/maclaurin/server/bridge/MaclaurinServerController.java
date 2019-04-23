package maclaurin.server.bridge;

import maclaurin.server.resources.*;
import maclaurin.*;
import java.util.Vector;
import java.net.*;
import java.io.*;
import maclaurin.server.commands.handlers.ExtCommandHandler;
import maclaurin.server.commands.handlers.factory.CommandHandlersFactory;
import maclaurin.server.commands.handlers.factory.CommandHandlersFactoryImp;
import maclaurin.server.commands.handlers.CommandHandler;

/**
 * Maclaurin server controller
 * 
 * @author Bartek
 * @version 3.0
 */
public class MaclaurinServerController {

    /**
     * @param connection server connection
     * @param serverLogicModel model created once for whole server lifetime
     */
    private final ServerSocket connection;
    private final MaclaurinModel serverLogicModel;

    /**
     * Sets basic parameters for server
     * 
     * @param port server communication port
     * @throws Exception can throws any exceptions.
     */
    public MaclaurinServerController(final int port) throws Exception {
        this.connection = new ServerSocket(port);
        this.serverLogicModel = new MaclaurinModelImp();
    }

    /**
     * Writes log on server console
    */
    public static void log(String message) {
        System.out.println(message);
    }
    
    /**
     * Runs server
     * @throws Exception can throws much exceptions
     */
    
    public void startServer() throws Exception {

        while (true) {
            Socket connectionSocket = connection.accept();
            try {
                handleClientRequest(new ClientConnectionImp(connectionSocket));
                connectionSocket.close();
            } catch (IOException e) {
                System.out.println("ERROR: Lost connection with client.");
            } catch (NullPointerException e) {
                System.out.println("ERROR: Client forced connection close.");
            }
        }
    }
    
    /**
     * 
     * @param client connection with connected client
     * @throws IOException if there any problem with connection.
     */
    @SuppressWarnings("empty-statement")
    private void handleClientRequest(ClientConnection client) throws IOException {
        ActionResolver resolver = new ActionResolverImp();

        while (true) {
            CommandParser commandParser = new CommandParser(client.reciveFromClient().trim());

            CommandHandlersFactory commandHandlersFactory = new CommandHandlersFactoryImp(client, commandParser.getParameters(), serverLogicModel);
            CommandHandler CommandHandler = commandHandlersFactory.get(resolver.getAction(commandParser.getCommand()));
            CommandHandler.handle();

            if (CommandHandler instanceof ExtCommandHandler) {
                serverLogicModel.empty();
                return;
            }

            printEndOfMessage(client);
        }
    }

    /**
     * writes end of message
     * @param client connection with client
     */
    private void printEndOfMessage(final ClientConnection client) {
        client.sendToClient("\0");
    }

}
