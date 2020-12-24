package com.blog.springblog.dto.user;

import com.blog.springblog.models.User;

public class UserFullData {

    String login;
    String password;
    String name;
    String lastname;
    String roleName;

    UserFullData(User user)
    {
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.name = user.getUserDetail().getName();
        this.lastname = user.getUserDetail().getLastname();
        this.roleName = user.getRole().getName();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getRoleName() {
        return roleName;
    }
}
