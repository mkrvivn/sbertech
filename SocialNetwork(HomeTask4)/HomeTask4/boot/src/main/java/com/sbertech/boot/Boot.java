package com.sbertech.boot;

import com.sbertech.users.UsersController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.sbertech"})
public class Boot {

    public static void main(String[] args)
    {
        SpringApplication.run(Boot.class, args);
    }
}
