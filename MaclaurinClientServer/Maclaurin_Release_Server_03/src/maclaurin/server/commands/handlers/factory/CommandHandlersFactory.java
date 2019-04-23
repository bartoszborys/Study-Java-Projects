/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers.factory;

import maclaurin.server.resources.ActionResolverEnum;
import maclaurin.server.commands.handlers.CommandHandler;

/**
 * Command Handlers factory
 * 
 * @author Bartek
 * @version 3.0
 */
public interface CommandHandlersFactory {
    /**
     * 
     * @param action enum value which tells factory which handler should create
     * @return Command handler
     */
    public CommandHandler get(ActionResolverEnum action);
}
