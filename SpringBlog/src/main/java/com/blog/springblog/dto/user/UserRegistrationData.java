package com.blog.springblog.dto.user;

public class UserRegistrationData {
    private String login;
    private String password;

    public UserRegistrationData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
