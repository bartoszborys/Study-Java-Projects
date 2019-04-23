/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers;

import java.io.IOException;

/**
 * Strategy for command handlers
 * 
 * @author Bartek
 * @version 3.0
 */
public interface CommandHandler {
    /**
     * Handles command
     * @throws IOException if there problems with connection
     */
    public void handle() throws IOException;
}
