package com.mohsinkd786.resources;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
