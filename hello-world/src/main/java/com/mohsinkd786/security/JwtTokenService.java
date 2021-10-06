package com.mohsinkd786.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenService implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 *60;

    public String JWT_SECRET = "secret";

    /*
    * Generate the token based on a dummy secret key
    * for serialization perform compaction
    * */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
    }

    // token validation
    public Boolean validateToken(String token, UserDetails userDetails){
        // validate token based on ttl if its expired ,
        // second if the token has the same details as the Principal Object
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isExpired(token));
    }

    private Boolean isExpired(String token){
        Date expiration = getClaimsFromToken(token,Claims::getExpiration);
        // compare with current date for expiration
        return expiration.before(new Date());
    }

    private <T> T getClaimsFromToken(String token, Function<Claims,T> claimsTFunction){
        final Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        return claimsTFunction.apply(claims);
    }

    public String getUsernameFromToken(String token){
        return getClaimsFromToken(token,Claims::getSubject);
    }
}
