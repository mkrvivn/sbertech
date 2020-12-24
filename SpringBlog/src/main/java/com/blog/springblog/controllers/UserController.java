package com.blog.springblog.controllers;

import com.blog.springblog.exceptions.user.UserNotFound;
import com.blog.springblog.models.Role;
import com.blog.springblog.models.User;
import com.blog.springblog.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    User getUser(@PathVariable Long id)
    {
        try
        {
            return userService.getUserById(id);
        }catch (UserNotFound e)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User Not Found", e);
        }

    }

    @GetMapping("/users")
    List<User> getUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping("/adduser")
    HttpStatus addUser(@RequestBody UserRegistration userRegistration)
    {
        userService.createUser(userRegistration.getLogin(), userRegistration.getPassword());
        return HttpStatus.OK;
    }

}

@Data
class UserRegistration
{
    private String login;
    private String password;
}
