package com.blog.springblog.exceptions.post;

public class PostNotFound extends Exception {
    public PostNotFound(String message)
    {
        super(message);
    }
}
