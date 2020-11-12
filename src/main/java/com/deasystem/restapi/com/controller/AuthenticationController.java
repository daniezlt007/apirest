package com.deasystem.restapi.com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deasystem.restapi.com.exception.LoginException;
import com.deasystem.restapi.com.modelo.Usuario;
import com.deasystem.restapi.com.modelo.UsuarioAuthenticationDto;
import com.deasystem.restapi.com.modelo.UsuarioDTO;
import com.deasystem.restapi.com.service.AuthenticateService;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

	@Autowired
	private AuthenticateService authenticateService;

	public AuthenticationController(AuthenticateService authenticateService) {
		super();
		this.authenticateService = authenticateService;
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> authenticationUser(@RequestBody UsuarioDTO usuario, @RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(), Authorization);			
			return new ResponseEntity<UsuarioAuthenticationDto>(UsuarioAuthenticationDto.toDto(usuarioLogado, "Bearer "), HttpStatus.ACCEPTED);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
