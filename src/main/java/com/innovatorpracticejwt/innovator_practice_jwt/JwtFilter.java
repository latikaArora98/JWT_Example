/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovatorpracticejwt.innovator_practice_jwt;

import com.innovatorpracticejwt.innovator_practice_jwt.util.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author 1460344
 */
public class JwtFilter extends GenericFilterBean {
	@Override
	public void doFilter(jakarta.servlet.ServletRequest sr, jakarta.servlet.ServletResponse sr1,
			jakarta.servlet.FilterChain fc) throws IOException, jakarta.servlet.ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
            return;
        }

        String token = authHeader.substring(7); // The part after "Bearer "

        try {
            Claims claims = Jwts.parser()
                                .setSigningKey(Constants.JWT_SECRET)
                                .parseClaimsJws(token)
                                .getBody();
            request.setAttribute("claims", claims);
        } catch (SignatureException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return;
        }

        fc.doFilter(sr, sr1);
    }

	

	
    
}
