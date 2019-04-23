package maclaurin.server.resources;

import java.io.*;
import java.net.*;

/**
 * parse string command to enum ID
 * @author Bartek
 * @version 3.0
 */
public class ActionResolverImp implements ActionResolver {

    /**
     * 
     * @param lineFromClient command to parse
     * @return parsed enum value
     * @throws IOException if there connecitons problem
     */
    @Override
    public ActionResolverEnum getAction(final String lineFromClient) throws IOException {
        if (lineFromClient.toUpperCase().equals("HELP")) {
            return ActionResolverEnum.HELP;
        }
        if (lineFromClient.toUpperCase().equals("ARG")) {
            return ActionResolverEnum.ARG;
        }
        if (lineFromClient.toUpperCase().equals("ACC")) {
            return ActionResolverEnum.ACC;
        }
        if (lineFromClient.toUpperCase().equals("EXE")) {
            return ActionResolverEnum.EXE;
        }
        if (lineFromClient.toUpperCase().equals("EXT")) {
            return ActionResolverEnum.EXT;
        }

        return ActionResolverEnum.UNKNOWN;
    }
}
