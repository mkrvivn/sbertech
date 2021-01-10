package org.example.terminal.exceptions;

public class ActiveSessionExist extends Exception{

    public ActiveSessionExist(String message)
    {
        super(message);
    }
}
