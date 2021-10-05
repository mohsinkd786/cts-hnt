package com.mohsinkd786.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloResource {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello Resource";
    }

    @GetMapping("/message/{str}")
    public String getMessage(@PathVariable("str") String msg){
        return "Message :"+msg;
    }

    @GetMapping(value = "/params",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getParams(@RequestParam String msg,@RequestParam boolean status){
       return status? msg: "No Message";
    }

}

/*
* Spring Rest : GET / POST / PUT / DELETE / PATCH
*
* PathVariables - they are ideally the mandatory params
* Request params - query params, ideally the optional ones
*
* */
