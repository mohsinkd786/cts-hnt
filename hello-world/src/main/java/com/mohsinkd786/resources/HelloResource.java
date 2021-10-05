package com.mohsinkd786.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello Resource";
    }
}

/*
* Spring Rest : GET / POST / PUT / DELETE / PATCH
*
* */
