package org.example.terminal;

public class TerminalState {
    private Integer AccountId;
    private String Pin;
    private AccountSession accountSession;

    public TerminalState(Integer accountId, String pin, AccountSession accountSession) {
        AccountId = accountId;
        Pin = pin;
        this.accountSession = accountSession;
    }

    public AccountSession getAccountSession() {
        return accountSession;
    }

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }

    public Integer getAccountId() {
        return AccountId;
    }

    public void setAccountId(Integer accountId) {
        AccountId = accountId;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String pin) {
        Pin = pin;
    }
}
