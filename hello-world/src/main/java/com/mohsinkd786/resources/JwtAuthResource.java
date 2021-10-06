package com.mohsinkd786.resources;

import com.mohsinkd786.security.JwtTokenService;
import com.mohsinkd786.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthResource {

    private AuthenticationManager authenticationManager;
    private JwtTokenService jwtTokenService;
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    public JwtAuthResource(AuthenticationManager authenticationManager,JwtTokenService jwtTokenService,JwtUserDetailsService jwtUserDetailsService){
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtTokenService.generateToken(userDetails);
        JwtResponse response = new JwtResponse();
        response.setToken(token);
        return ResponseEntity.ok(response);
    }
    private void authenticate(String username,String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (Exception ex){
            throw new Exception("Invalid or Bad Credentials",ex);
        }
    }
}
