package com.sbertech.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {

    @GetMapping(value="/test2")
    String test()
    {
        return "Hello world";
    }

    @GetMapping(value="/getAllUserNames")
    public List<String> getAllUserNames()
    {
        List<String> ls = new ArrayList<>();
        ls.add("Sam");
        ls.add("Bob");
        return ls;
    }
}
