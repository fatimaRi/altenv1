package com.alten.project.security;

import java.io.IOException;
import java.security.Signature;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.alten.project.entities.AppUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter{
 private AuthenticationManager authenticationManager;
 
	

	/**
 * @param authenticationManager
 */
public JwtAuthFilter(AuthenticationManager authenticationManager) {
	this.authenticationManager = authenticationManager;
}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		AppUser appUser=null;
		try {
			appUser=new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getNom(), appUser.getPassword()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User springUser=(User) authResult.getPrincipal();
		String jwt=Jwts.builder()
				.setSubject(springUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+SecuConstants.Expiration_Time))
				.signWith(SignatureAlgorithm.HS256,SecuConstants.SECRET)
				.claim("roles",springUser.getAuthorities())
				.compact();
		response.addHeader(SecuConstants.HEADER_STRING, SecuConstants.Token_PREFEX+jwt);
				
				
		
	}
	
}