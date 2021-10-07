package com.mohsinkd786.controller;

import com.mohsinkd786.entity.User;
import com.mohsinkd786.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private UserService service;
    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers(){
        return service.getUsers();
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable String userId){
        return ResponseEntity.ok(service.deleteUser(userId));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(service.addUser(user));
    }

    @GetMapping("/findBySalary")
    public List<User> findUsersBySalary(@RequestParam(defaultValue = "0") double salary){
        return service.findUsersBySalaryGreaterThan(salary);
    }
}
