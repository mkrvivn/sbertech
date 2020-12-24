package com.sbertech.boot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value="/test")
    String test()
    {
        return "Hello world";
    }
}
