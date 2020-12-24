package com.blog.springblog.exceptions.user;

public class UserNotFound extends Exception {

    public UserNotFound(String message)
    {
        super(message);
    }
}
