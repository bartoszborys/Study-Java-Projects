/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.client.bridge;
import java.io.*;
import java.net.*;
import java.time.Instant;
import maclaurin.MaclaurinViewResultOnly;
/**
 *
 * Client controller
 * 
 * @author Bartek
 * @version 3.0
 */
public class MaclaurinClientController {
    final long TIMEOUT_SECONDS = 5;
    MaclaurinViewResultOnly view;
    BufferedReader userWriter;
    Socket connection;
    
    /**
     * 
     * @param ip adress to connect
     * @param port port to connect
     * @throws UnknownHostException if host doesn't exists
     * @throws IOException if there problems with connection
     */
    public MaclaurinClientController(String ip, int port) throws UnknownHostException, IOException{
        this.userWriter = new BufferedReader( new InputStreamReader(System.in) );
        connection = new Socket( ip, port );
        view = new MaclaurinViewResultOnly();
    }
    /**
     * handles client requests
     * @throws IOException if there is problems with connection
     */
    public void handle() throws IOException{    

        String result = "";
        PrintWriter outputStream = new PrintWriter( connection.getOutputStream(), true );
        BufferedReader inputStream = new BufferedReader( new InputStreamReader(connection.getInputStream()) );
            
        while(true){
            String stringFound = userWriter.readLine();
            outputStream.println( stringFound );
            
            try{
                result = this.getMessageFromServer(inputStream);
            }catch(IOException e){
                System.out.println("ERROR: Connection lost due to unknown problem.");
                break;
            }catch(TimeoutException e){
                System.out.println(e.getMessage());
                break;
            }
            
            if( result.toUpperCase().equals("EXT_GOOD\n") )
               break;
            
            view.update(result);
            result = "";
        }
        
        if( !connection.isClosed() )
            connection.close();
    }
    
    /**
     * 
     * @param inputStream stream from client
     * @return message from client
     * @throws IOException if there problems with conneciton
     * @throws TimeoutException If wait takes too much time
     */
    private String getMessageFromServer(final BufferedReader inputStream) throws IOException, TimeoutException{
        StringBuilder everything = new StringBuilder();
        String lineFromServer;
        
        waitUntilStreamIsReady(inputStream);
        
        while(true){
           lineFromServer = inputStream.readLine();
           
           if(lineFromServer.equals("\0"))
               break;
           
           everything.append( lineFromServer ).append("\n");
        };
        
        return everything.toString();
    }
    /**
     * Waits until stream from server is ready
     * @param inputStream stream from server
     * @throws IOException if there problems with conneciton
     * @throws TimeoutException If wait takes too much time
     */
    private void waitUntilStreamIsReady(final BufferedReader inputStream) throws IOException, TimeoutException{
        TimeoutGuardian guardian = new TimeoutGuardian();
        guardian.setTimeout(this.TIMEOUT_SECONDS);
        
        guardian.start();
        while( !inputStream.ready() ){
            if( guardian.checkTimeout() )
                throw new TimeoutException("REASON: Server not response");
        };
    }    
}
