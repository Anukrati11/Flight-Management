package com.pjsoft.fms.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private long tokenValidity; // in milliseconds

    // Generate JWT Token
    // add the USerID+emailid in claims
    public String generateAuthToken(String userName){
        Map<String, Object> claims = new HashMap<>();
        claims.put("correlationId", getCorrelationId());
        claims.put("emailId", getEmailId());
        claims.put("UserId", userName);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidity))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    public static String getEmailId(){
        return "anu@gmail.com";
    }
    // Generate a unique Correlation ID using UUID
    public static String getCorrelationId() {
        return UUID.randomUUID().toString();
    }

    // Validate JWT token - check username and expiry
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // Extract username from token
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Extract all claims
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    // Check if the token is expired
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
