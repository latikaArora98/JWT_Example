/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovatorpracticejwt.innovator_practice_jwt.util;

import com.innovatorpracticejwt.innovator_practice_jwt.models.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

/**
 *
 * @author 1460344
 */
public class JWTUtils {

    public String CreateJWTToken(Users user) {
        
        Claims claims= Jwts.claims();
        claims.put("name", user.getUserName());
        claims.put("email", user.getEmail());
        claims.put("user_id", user.getUserId());
        claims.setSubject("MY Blog");
        claims.setIssuedAt(new Date());
        
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, Constants.JWT_SECRET)
                .compact();
        
        return token;
    }
}
