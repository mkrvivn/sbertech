package org.example.terminal;

import org.example.terminal.exceptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {

    private AccountServer accountServer;
    private TerminalState terminalState;

    public Terminal()
    {
        this.terminalState = new TerminalState(null, null, null);
    }

    public float getAccountBalance() throws IllegalAccountSession
    {
        return accountServer.getAccountBalance(terminalState.getAccountSession());
    }

    public AccountSession getAccountSession()
    {
        return terminalState.getAccountSession();
    }

    public Terminal setAccountServer(AccountServer accountServer)
    {
        this.accountServer = accountServer;
        return this;
    }

    public Terminal setAccountId(Integer accountId) throws ActiveSessionExist
    {
        if(terminalState.getAccountSession() != null)
            throw new ActiveSessionExist("session should be terminated before processing new input");
        terminalState.setAccountId(accountId);
        return this;
    }

    public Terminal processInput(String pin) throws IllegalPin, ActiveSessionExist
    {
        if(terminalState.getAccountSession() != null)
            throw new ActiveSessionExist("session should be terminated before processing new input");
        if(VerifyUtils.verifyPin(pin))
            this.terminalState.setPin(pin);
        return this;
    }

    //точно ли можно стандартными средствами java читать по символу с консоли?
    public Terminal processInput(char key) throws IllegalPinChar, ActiveSessionExist
    {
        if(terminalState.getAccountSession() != null)
            throw new ActiveSessionExist("session should be terminated before processing new input");
        if(Character.isDigit(key))
            terminalState.setPin(terminalState.getPin() + key);
        else
            throw new IllegalPinChar("pin should contain only digits");
        return this;
    }

    public Terminal auth() throws IllegalPin
    {
        if(terminalState.getPin().length() != 4)
            throw new IllegalPin("pin length should be 4");
        terminalState.setAccountSession(accountServer.authorize(terminalState.getAccountId(), terminalState.getPin()));
        return this;
    }

    public Terminal putMoney(Integer amount) throws IllegalBalance, IllegalAccountSession
    {
        VerifyUtils.verifyMoneyAmount(amount);
        accountServer.putMoneyOnAccount(terminalState.getAccountSession(), amount);
        return this;
    }

    public Terminal getMoney(Integer amount) throws IllegalBalance, IllegalAccountSession
    {
        VerifyUtils.verifyMoneyAmount(amount);
        accountServer.getMoneyFromAccount(terminalState.getAccountSession(), amount);
        return this;
    }

    public Terminal clearState()
    {
        this.terminalState = new TerminalState(null, null, null);
        return this;
    }




}
