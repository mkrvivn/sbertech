package com.blog.springblog.controller;

import com.blog.springblog.dto.FullUserInfo;
import com.blog.springblog.exceptions.NotFound;
import com.blog.springblog.model.User;
import com.blog.springblog.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Data
    public static class CreateUser
    {
        String login;
        String email;
        String password;
    }

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    FullUserInfo getUserInfo(@PathVariable Long id)
    {
        try {
            return new FullUserInfo(userService.getUserById(id));
        } catch (Exception e)
        {
            throw new NotFound();
        }

    }

    @PostMapping("/user")
    String addUser(@RequestBody CreateUser user)
    {
        userService.addUser(new User(user.login, user.email, user.password));
        return "user added";
    }

    @GetMapping("/users")
    List<FullUserInfo> getAllUsers()
    {
        return userService.getAllUsers().stream().map(FullUserInfo::new).collect(Collectors.toList());
    }

}
