package org.example.terminal.exceptions;

public class AccountNotFound extends Exception{
    AccountNotFound(String message)
    {
        super(message);
    }

    public AccountNotFound(String message, Throwable cause)
    {
        super(message, cause);
    }
}
