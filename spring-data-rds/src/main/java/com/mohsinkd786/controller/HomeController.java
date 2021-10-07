package com.mohsinkd786.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String sayHello(){
        return "Home Controller";
    }
}
