/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.resources;

import static maclaurin.server.bridge.MaclaurinServerController.log;

/**
 * Command from client parser 
 * 
 * @author Bartek
 * @version 3.0
 */
public class CommandParser {
    
    /**
     * @param command commnad
     * @param parameters command parameters
     */
    private final String command;
    private final String parameters;

    /**
     * parse command
     * @param commandToParse command to parse
     */
    public CommandParser(String commandToParse) {
        log("FROM CLIENT: " + commandToParse);
        command = commandToParse.split(" ")[0];
        parameters = commandToParse.replaceFirst(command, "").trim();
    }

    /**
     * returns command
     * @return command
     */
    public String getCommand() {
        return command;
    }

    /**
     * returns command Parameters
     * @return command Parameters
     */
    public String getParameters() {
        return parameters;
    }

}
