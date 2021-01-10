package org.example.terminal;

import org.example.terminal.exceptions.IllegalBalance;
import org.example.terminal.exceptions.IllegalPin;

public class Account {

    private Integer id;
    private float balance;
    private String pin;

    public Account(Integer id, String pin) throws IllegalPin
    {
        this.id = id;
        this.pin = pin;
    }

    public void setPin(String pin) throws IllegalPin
    {
        if(VerifyUtils.verifyPin(pin))
            this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) throws IllegalBalance {
        if(balance < 0f)
            throw new IllegalBalance("balance can't be negative");
        this.balance = balance;
    }




}
