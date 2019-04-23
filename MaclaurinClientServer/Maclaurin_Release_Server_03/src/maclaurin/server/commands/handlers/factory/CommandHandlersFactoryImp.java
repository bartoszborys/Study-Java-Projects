/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.commands.handlers.factory;

import maclaurin.MaclaurinModel;
import maclaurin.MaclaurinModelEdit;
import maclaurin.MaclaurinModelExecution;
import maclaurin.server.bridge.ClientConnection;
import maclaurin.server.commands.handlers.*;
import maclaurin.server.resources.ActionResolverEnum;

/**
 * creates command handler
 * 
 * @author Bartek
 * @version 3.0
 */
public class CommandHandlersFactoryImp implements CommandHandlersFactory {

    private final String messageToHandle;
    private final ClientConnection client;
    private final MaclaurinModel serverLogicModel;

    /**
     * sets basic parameters
     * @param client conenction with client
     * @param message message from client
     * @param serverLogicModel whole server logic
     */
    public CommandHandlersFactoryImp(ClientConnection client, String message, MaclaurinModel serverLogicModel) {
        this.serverLogicModel = serverLogicModel;
        this.messageToHandle = message;
        this.client = client;
    }

    /**
     * creates object to handle command
     * @param action parsed enum command value
     * @return object to handle command
     */
    @Override
    public CommandHandler get(ActionResolverEnum action) {
        switch (action) {
            case HELP:
                return new HelpCommandHandler(client, messageToHandle);

            case ARG:
                return new ArgCommandHandler(client, messageToHandle, (MaclaurinModelEdit)serverLogicModel);

            case ACC:
                return new AccCommandHandler(client, messageToHandle, (MaclaurinModelEdit)serverLogicModel);

            case EXE:
                return new ExeCommandHandler(client, messageToHandle, (MaclaurinModelExecution)serverLogicModel);

            case EXT:
                return new ExtCommandHandler(client);

            default:
                return new UnknownCommandHandler(client);

        }
    }

}
