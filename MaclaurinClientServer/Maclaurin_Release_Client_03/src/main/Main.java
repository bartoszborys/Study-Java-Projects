/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import maclaurin.client.bridge.MaclaurinClientController;
/**
 *
 * @author Bartek
 */
public class Main {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        try{
        MaclaurinClientController Client = new MaclaurinClientController("localhost", 8888); 
        Client.handle();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("ERROR: Unknow exception durning clinet works");
        }
                
    }
    
}
