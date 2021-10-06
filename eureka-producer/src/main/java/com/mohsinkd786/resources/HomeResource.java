package com.mohsinkd786.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
    @GetMapping("/hello")
    public String sayHello(){
        return "Server is running at 5002";
    }
}
