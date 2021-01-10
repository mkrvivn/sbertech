package org.example.urlreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsolePorcessorImpl implements ConsoleProcessor
{
    @Override
    public String readCommand() throws IOException {
        String command;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        command = reader.readLine();
        return command;
    }

    @Override
    public void printCommand(String command) {
        System.out.println(command);
    }
}
