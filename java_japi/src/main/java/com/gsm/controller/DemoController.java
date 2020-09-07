package com.gsm.controller;

import com.gsm.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("japi")
public class DemoController {

    @PostMapping("u")
    public User insertUser(@RequestBody User u) {
        User user = User.builder()
                .name(u.getName())
                .age(u.getAge())
                .build();
        return user;
    }

    @GetMapping("u")
    public User selectUser() {
        User user = User.builder()
                .name(UUID.randomUUID().toString())
                .age(18)
                .build();
        return user;
    }
}
