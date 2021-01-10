package org.example.terminal;

import org.example.terminal.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class AccountServer {

    private List<Account> accountList;

    public AccountServer() {
        accountList = new ArrayList<Account>();
    }

    public AccountSession authorize(Integer accountId, String pin)
    {
        try
        {
            Account account = accountList.get(accountId);
            if(account.getPin().equals(pin))
                return new AccountSession(accountId, AccountSessionStatus.AUTHORIZED);
            else
                return new AccountSession(accountId, AccountSessionStatus.DENIED);
        } catch (IndexOutOfBoundsException e)
        {
            return new AccountSession(accountId, AccountSessionStatus.DENIED);
        }
    }

    private Account getAccount(AccountSession accountSession) {
        try {
            return accountList.get(accountSession.getAccountId());
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public float getAccountBalance(AccountSession accountSession) throws IllegalAccountSession {
        verifySession(accountSession);
        return getAccount(accountSession).getBalance();
    }

    public void putMoneyOnAccount(AccountSession accountSession, int moneyAmount) throws IllegalBalanceOperation,
            IllegalBalance, IllegalAccountSession {
        verifySession(accountSession);
        if(VerifyUtils.verifyMoneyAmount(moneyAmount))
        {
            Account account = getAccount(accountSession);
            account.setBalance(account.getBalance() + moneyAmount);
        }
    }

    public void getMoneyFromAccount(AccountSession accountSession, int moneyAmount) throws IllegalBalanceOperation,
            IllegalBalance, IllegalAccountSession {
        verifySession(accountSession);
        if(VerifyUtils.verifyMoneyAmount(moneyAmount))
        {
            Account account = getAccount(accountSession);
            account.setBalance(account.getBalance() - moneyAmount);
        }
    }

    //т.к. данный метод для генерации аккаунтов испольлзует толко hardcoded значения, то ошибки в нем не перехватывются
    public void generateAccount(String pin) throws IllegalPin {
        this.accountList.add(new Account(accountList.size(), pin));
    }

    private void verifySession(AccountSession accountSession) throws IllegalAccountSession
    {
        if(accountSession.getStatus() != AccountSessionStatus.AUTHORIZED)
            throw new IllegalAccountSession("unable to verify session");
    }


}
