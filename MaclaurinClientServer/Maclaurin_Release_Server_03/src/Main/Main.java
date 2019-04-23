/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import maclaurin.server.bridge.MaclaurinServerController;

/**
 *
 * @author Bartek
 */
public class Main {

    public static void main(String argv[]) throws Exception{
        try{
            MaclaurinServerController ServerInstance = new MaclaurinServerController(8888);
            ServerInstance.startServer();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    
}
