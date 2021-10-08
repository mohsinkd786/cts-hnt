package com.mohsinkd786.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("{msg}")
    public ResponseEntity<String> message(@PathVariable String msg){
        return ResponseEntity.ok("Msg : "+msg);
    }
}
