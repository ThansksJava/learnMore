package com.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@RestController
public class PersonController {
    @GetMapping("/hello")
    public String test(){
        return "hello 1234";
    }

}
