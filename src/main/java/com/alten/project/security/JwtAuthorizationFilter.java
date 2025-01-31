package com.alten.project.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin,Accept,X-Requested-With,Content-Type,"
				 + "Access-Control-Requested-Method, "
				+"Access-Control-Requested-Headers,"
				+"Authorization"
				);
		response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,"
				+"Access-Control-Allow-Credentials, Authorization");

		String jwt=request.getHeader(SecuConstants.HEADER_STRING);
	System.out.println(jwt+"hhhhhhhhhhhhhhhhhhhhhh");
	if(request.getMethod().equals("OPTIONS")){
		response.setStatus(HttpServletResponse.SC_OK);
	}
	else{
		if(jwt==null || jwt.startsWith(SecuConstants.Token_PREFEX)){
			filterChain.doFilter(request, response);
			return;
		}
		Claims claims=Jwts.parser()
				.setSigningKey(SecuConstants.SECRET)
				.parseClaimsJws(jwt.replace(SecuConstants.Token_PREFEX,""))
				.getBody();
		String username=claims.getSubject();
		ArrayList<Map<String,String>> roles=(ArrayList<Map<String,String>>)
				claims.get("roles");
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		roles.forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			
		});
		UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(username, null,authorities);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		filterChain.doFilter(request,response);	}

	}
		
	}
