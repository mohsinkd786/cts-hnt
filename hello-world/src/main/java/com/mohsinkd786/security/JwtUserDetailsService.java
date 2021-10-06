package com.mohsinkd786.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    private String username = "techmomo";

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if(username.equals(userName)){
            // password is encrypted
            return new User(username,"$2a$12$Qr7eFBl0bWISGitra2voCuwd9WdZbq15elrzJVdczFG.IPVVo2IPe",new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("No user found with "+username);
        }
    }
}
