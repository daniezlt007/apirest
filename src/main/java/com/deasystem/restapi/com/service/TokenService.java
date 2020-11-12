package com.deasystem.restapi.com.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.deasystem.restapi.com.modelo.Usuario;
import com.deasystem.restapi.com.util.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	public String generateToken(Usuario usuario) {
		return Jwts.builder().setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(usuario.getId()+"")
				.setExpiration(new Date(System.currentTimeMillis() + Util.TOKEN_EXPIRATION))
				.signWith(SignatureAlgorithm.HS256, Util.SECRET_KEY)
				.compact();
	}

	public Claims decodeToken(String token) {
		return Jwts.parser()
				.setSigningKey(Util.SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
	}

}
