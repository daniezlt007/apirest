package com.deasystem.restapi.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deasystem.restapi.com.exception.LoginException;
import com.deasystem.restapi.com.modelo.Usuario;
import com.deasystem.restapi.com.repository.UsuarioRepository;

@Service
public class UsuarioImplementUsuario implements UsuarioService{
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioImplementUsuario(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) this.usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> find(Long id) {
		return this.usuarioRepository.findById(id);
	}

	@Override
	public Usuario create(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	

}
