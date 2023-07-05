package com.linlite.bootdemo.controller;

import com.linlite.bootdemo.entity.Greeting;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name, Authentication authentication) {
        return new Greeting(counter.incrementAndGet(), String.format(template, authentication.isAuthenticated() ? authentication.getName() : name));
    }
}
