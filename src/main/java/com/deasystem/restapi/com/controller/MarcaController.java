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
import com.deasystem.restapi.com.modelo.Marca;
import com.deasystem.restapi.com.modelo.Patrimonio;
import com.deasystem.restapi.com.modelo.Usuario;
import com.deasystem.restapi.com.modelo.UsuarioDTO;
import com.deasystem.restapi.com.service.AuthenticateService;
import com.deasystem.restapi.com.service.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@Autowired
	private AuthenticateService authenticateService;

	public MarcaController(MarcaService marcaService, AuthenticateService authenticateService) {
		super();
		this.marcaService = marcaService;
		this.authenticateService = authenticateService;
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findAll(@RequestBody UsuarioDTO usuario, @RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(),
					Authorization);

			if (usuarioLogado != null) {
				List<Marca> list = this.marcaService.findAll();
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
	public ResponseEntity<?> create(@RequestBody Marca marca, @RequestBody UsuarioDTO usuario,
			@RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(),
					Authorization);
			if (usuarioLogado != null) {
				Marca marcaCreated = this.marcaService.create(marca);
				return new ResponseEntity<Marca>(marcaCreated, HttpStatus.CREATED);
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuario,
			@RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(),
					Authorization);

			if (usuarioLogado != null) {
				Optional<Marca> product = this.marcaService.find(id);
				return new ResponseEntity<Optional>(product, HttpStatus.OK);
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
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Marca marca,
			@RequestBody UsuarioDTO usuario, @RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(),
					Authorization);

			if (usuarioLogado != null) {
				Marca marcaUpdated = this.marcaService.create(marca);
				return new ResponseEntity<Marca>(marcaUpdated, HttpStatus.OK);
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuario,
			@RequestHeader String Authorization) {
		try {
			Usuario usuarioLogado = this.authenticateService.authenticate(usuario.getEmail(), usuario.getSenha(),
					Authorization);
			if (usuarioLogado != null) {
				this.marcaService.delete(id);
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
