package com.deasystem.restapi.com.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deasystem.restapi.com.modelo.Usuario;
import com.deasystem.restapi.com.modelo.UsuarioAuthenticationDto;
import com.deasystem.restapi.com.modelo.UsuarioDTO;
import com.deasystem.restapi.com.service.TokenService;
import com.deasystem.restapi.com.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private UsuarioService usuarioService;
	private TokenService tokenService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService, TokenService tokenService) {
		super();
		this.usuarioService = usuarioService;
		this.tokenService = tokenService;
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findAll() {
		List<Usuario> list = this.usuarioService.findAll();
		return new ResponseEntity<List>(list, HttpStatus.OK);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		usuario.setToken(tokenService.generateToken(usuario));
		Usuario usuarioCreated = this.usuarioService.create(usuario);
		return new ResponseEntity<UsuarioAuthenticationDto>(UsuarioAuthenticationDto.toDto(usuarioCreated, "Bearer "), HttpStatus.CREATED);
	}

}
