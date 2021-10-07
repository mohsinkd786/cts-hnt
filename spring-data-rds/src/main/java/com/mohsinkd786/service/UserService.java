package com.mohsinkd786.service;

import com.mohsinkd786.entity.User;
import com.mohsinkd786.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo repo;

    @Autowired
    public UserService(UserRepo repo){
        this.repo = repo;
    }

    public List<User> getUsers(){
        //return repo.findAll();

        List<User> userList = new ArrayList();
        repo.findAll().forEach(user -> userList.add(user));
        return userList;
    }

    @Transactional
    public boolean deleteUser(String userId){
//        List<User> users = getUsers();
//        boolean isDeleted = false;
//        Optional<User> userOptional = users.stream().filter(u-> u.getUserId().equals(userId)).findFirst();
//        if(userOptional.isPresent()){
//            // delete the user in case existing
//            repo.delete(userOptional.get());
//            isDeleted = true;
//        }
//        return isDeleted;
        repo.deleteByUserId(userId);
        return true;
    }

    public User addUser(User user){
        return repo.save(user);
    }

    public List<User> findUsersBySalaryGreaterThan(double salary){
        List<User> users = new ArrayList<>();
        repo.getUsersBySalaryMoreThan(salary).forEach(user -> users.add(user));
        return users;
    }
}
