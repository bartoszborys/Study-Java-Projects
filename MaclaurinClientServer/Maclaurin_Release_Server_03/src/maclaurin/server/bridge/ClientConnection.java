/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.bridge;

import java.io.IOException;
import java.net.Socket;

/**
 * Interface which helps user make tests.
 * Implementation is hidden
 * 
 * @author Bartek
 * @version 3.0
 */
public interface ClientConnection {
     public Socket getConnecitonSocket();
     public void sendToClient(final String message);
     public String reciveFromClient() throws IOException;
}
