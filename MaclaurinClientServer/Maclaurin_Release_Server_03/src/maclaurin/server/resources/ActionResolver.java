/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.resources;

import java.io.IOException;

/**
 * Action resolver interface
 * @author Bartek
 * @version 3.0
 */
public interface ActionResolver {
    /**
     * 
     * @param lineFromClient command to parse
     * @return enum value of command
     * @throws IOException if there problems with connection
     */
    public ActionResolverEnum getAction(final String lineFromClient) throws IOException;
}
