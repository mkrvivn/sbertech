package org.example.terminal;

public class AccountSession {
    private AccountSessionStatus status;
    private Integer accountId;

    public AccountSession(Integer accountId, AccountSessionStatus status) {
        this.status = status;
        this.accountId = accountId;
    }

    public AccountSessionStatus getStatus() {
        return status;
    }

    public void setStatus(AccountSessionStatus status) {
        this.status = status;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
