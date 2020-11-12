package com.deasystem.restapi.com.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deasystem.restapi.com.exception.ExpirationException;
import com.deasystem.restapi.com.exception.InvalidToken;
import com.deasystem.restapi.com.exception.LoginException;
import com.deasystem.restapi.com.modelo.Usuario;
import com.deasystem.restapi.com.repository.UsuarioRepository;

import io.jsonwebtoken.Claims;

@Service
public class AuthenticateService {

	private UsuarioRepository usuarioRepository;
	private TokenService tokenService;
	
	@Autowired
	public AuthenticateService(UsuarioRepository usuarioRepository, TokenService tokenService) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.tokenService = tokenService;
	}
	
	public Usuario authenticate(String email, String senha, String Authorization) throws LoginException {
		Usuario usuario = this.usuarioRepository.findByEmailAddress(email);
		if(senha.equals(usuario.getSenha()) && !Authorization.isEmpty() && validateToken(Authorization)) {
			return usuario;
		}else {
			throw new LoginException();
		}
	}

	private boolean validateToken(String Authorization) {
		try {
			try {
				String tokenTratado = Authorization.replace("Bearer ", "");
				Claims claims = tokenService.decodeToken(tokenTratado);
				if(claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpirationException();
				return true;
			}catch(ExpirationException ex) {
				ex.printStackTrace();
				throw ex;
			}catch(Exception e) {
				e.printStackTrace();
				throw new InvalidToken();
			}
		} catch (ExpirationException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
