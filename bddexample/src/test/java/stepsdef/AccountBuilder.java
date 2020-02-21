package stepsdef;

import account.Account;

public class AccountBuilder {

    private String username;
    private String password;

    public AccountBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public AccountBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public Account create() {
        return new Account(username, password);
    }
}
