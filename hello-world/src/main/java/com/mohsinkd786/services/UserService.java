package com.mohsinkd786.services;

import com.mohsinkd786.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<UserDto> userDtos = new ArrayList<>();

    public List<UserDto> findUsers(){
        return userDtos;
    }

    public boolean addUser(UserDto userDto){
        userDtos.add(userDto);
        return true;
    }
    public boolean deleteById(int id){
        userDtos = userDtos.stream().filter(u-> u.getId() != id).collect(Collectors.toList());
        return true;
    }
    public UserDto findById(int id){
        Optional<UserDto> optionalUserDto = userDtos.stream().filter(u-> u.getId() == id).findFirst();
        return optionalUserDto.isPresent() ? optionalUserDto.get(): null;
    }
}
