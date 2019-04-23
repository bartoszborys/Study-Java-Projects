/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FakeClasses;

import java.io.IOException;
import java.net.Socket;
import maclaurin.server.bridge.ClientConnection;

/**
 *
 * @author Bartek
 */
public class ClientConnectionFake implements ClientConnection{

    private StringBuilder messageToClient = new StringBuilder();
    
    @Override
    public Socket getConnecitonSocket() {
        return new SocketFake();
    }

    @Override
    public void sendToClient(String message) {
        messageToClient.append(message);
    }

    @Override
    public String reciveFromClient() throws IOException {
        return "";
    }
    
    public String getClientMessageResult(){
        return messageToClient.toString();
    }
}

class SocketFake extends Socket{
    
}