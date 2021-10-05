package com.mohsinkd786.resources;

import com.mohsinkd786.dtos.UserDto;
import com.mohsinkd786.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserResource {

    private UserService userService;

    @Autowired
    public UserResource(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> findUsers(){
        return userService.findUsers();
    }

    @GetMapping("{id}")
    public UserDto findUserById(@PathVariable int id){
        return userService.findById(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteUserById(@PathVariable int id){
        return userService.deleteById(id);
    }

    @PostMapping
    public boolean addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }
}
