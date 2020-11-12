package com.deasystem.restapi.com.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deasystem.restapi.com.exception.LoginException;
import com.deasystem.restapi.com.modelo.Patrimonio;
import com.deasystem.restapi.com.modelo.Usuario;
import com.deasystem.restapi.com.modelo.UsuarioAuthenticationDto;
import com.deasystem.restapi.com.modelo.UsuarioDTO;
import com.deasystem.restapi.com.service.AuthenticateService;
import com.deasystem.restapi.com.service.PatrimonioService;

@RestController
@RequestMapping("/patrimonio")
public class PatrimonioController {

	@Autowired
	private PatrimonioService patrimonioService;
	
	@Autowired
	private AuthenticateService authenticateService;

	public PatrimonioController(PatrimonioService patrimonioService, AuthenticateService authenticateService) {
		super();
		this.patrimonioService = patrimonioService;
		this.authenticateService = authenticateService;
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findAll(@RequestBody UsuarioDTO usuario, @RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(), Authorization);
			if(usuarioLogado != null) {
				List<Patrimonio> list = this.patrimonioService.findAll();
				return new ResponseEntity<List>(list, HttpStatus.OK);
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Patrimonio patrimonio, @RequestBody UsuarioDTO usuario, @RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(), Authorization);
			if(usuarioLogado != null) {
				Patrimonio patrimonioCreated = this.patrimonioService.create(patrimonio);
				return new ResponseEntity<Patrimonio>(patrimonioCreated, HttpStatus.CREATED);
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuario, @RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(), Authorization);
			if(usuarioLogado != null) {
				Optional<Patrimonio> patrimonio = this.patrimonioService.find(id);
				return new ResponseEntity<Optional>(patrimonio, HttpStatus.OK);
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Patrimonio patrimonio, @RequestBody UsuarioDTO usuario, @RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(), Authorization);
			if(usuarioLogado != null) {
				Patrimonio patrimonioUpdated = this.patrimonioService.create(patrimonio);
				return new ResponseEntity<Patrimonio>(patrimonioUpdated, HttpStatus.OK);
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id, @RequestBody Patrimonio patrimonio, @RequestBody UsuarioDTO usuario, @RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(), Authorization);
			if(usuarioLogado != null) {
				this.patrimonioService.delete(id);
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
