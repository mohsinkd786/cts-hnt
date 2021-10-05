package com.mohsinkd786.resources;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/messages")
@RestController
public class MessageResource {

    private List<String> messages;

    public MessageResource(){
        messages = new ArrayList<>();
    }

    @GetMapping
    public List<String> getAllMessages(){
        return messages;
    }

    @PostMapping
    public boolean addMessage(@RequestBody String message){
        messages.add(message);
        return true;
    }
}
