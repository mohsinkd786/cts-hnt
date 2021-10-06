package com.mohsinkd786.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageResource {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("{msg}")
    public String getMessage(@PathVariable String msg){
        return "Msg : "+msg;
    }
}
