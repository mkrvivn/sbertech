package org.example.urlreader;

import java.io.IOException;

public interface ConsoleProcessor {

    String readCommand() throws IOException;

    void printCommand(String command);
}
