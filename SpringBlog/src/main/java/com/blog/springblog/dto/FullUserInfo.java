package com.blog.springblog.dto;


import com.blog.springblog.model.User;
import lombok.Data;

@Data
public class FullUserInfo {

    public FullUserInfo(User user)
    {
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getUserDetail().getName();
        this.lastname = user.getUserDetail().getLastname();
    }

    private String login;
    private String email;
    private String password;
    private String name;
    private String lastname;
}
