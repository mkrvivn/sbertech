package org.example.terminal;

import org.example.terminal.exceptions.IllegalBalance;
import org.example.terminal.exceptions.IllegalBalanceOperation;
import org.example.terminal.exceptions.IllegalPin;

public class VerifyUtils {

    public static boolean verifyMoneyAmount(int amount) throws IllegalBalanceOperation
    {
        if (amount % 100 != 0)
            throw new IllegalBalanceOperation("amount of deposit must be a multiple of 100");
        return true;
    }

    public static boolean verifyPin(String pin) throws IllegalPin
    {
        if(pin.length() != 4)
            throw new IllegalPin("pin length must be 4");
        if(!allCharIsDig(pin))
            throw new IllegalPin("pin should contains only digits");
        return true;
    }

    public static boolean allCharIsDig(String pin)
    {
        for (int i = 0; i < pin.length(); i++)
            if(!Character.isDigit(pin.charAt(i)))
                return false;
        return true;
    }
}
