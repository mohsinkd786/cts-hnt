package com.mohsinkd786.resources;

import com.mohsinkd786.services.ProducerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    private ProducerClientService producerClientService;

    @Autowired
    public HelloResource(ProducerClientService producerClientService){
        this.producerClientService = producerClientService;
    }

    @GetMapping("/hello/message")
    public String getHelloMessage(){
        return producerClientService.getMessage();
    }
}
