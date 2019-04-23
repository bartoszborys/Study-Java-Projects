/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Warpper for client connection
 * @author Bartek
 * @version 3.0
 */
public class ClientConnectionImp implements ClientConnection{
    
    /**
     * @param streamFromClient stream from client
     * @param streamToClient stream to client
     * @param connectionWithClient connection with client
     */
    private final BufferedReader streamFromClient;
    private final PrintWriter streamToClient;
    private final Socket connectionWithClient;
    
    /**
     * Sets basic parameters for object ( Builds ) 
     * 
     * @param connectionSocket whole connection with client
     * @throws IOException if there problems with connection
     */
    public ClientConnectionImp(Socket connectionSocket) throws IOException {
        connectionWithClient = connectionSocket;
        streamFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        streamToClient = new PrintWriter(connectionSocket.getOutputStream(), true);
    }

    /**
     * returns connection socket
     * 
     * @return connection with client
     */
    @Override
    public Socket getConnecitonSocket() {
        return this.connectionWithClient;
    }
    
    /**
     * Writes to client
     * 
     * @param message message which will send to client
     */
    
    @Override
    public void sendToClient(final String message) {
        streamToClient.println(message);
    }
    
    /**
     * Reads buffer from client
     * 
     * @return message from client
     * @throws IOException if there problems with connection
     */
    
    @Override
    public String reciveFromClient() throws IOException {
        return streamFromClient.readLine();
    }
}
