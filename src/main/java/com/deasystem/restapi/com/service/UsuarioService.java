package com.deasystem.restapi.com.service;

import java.util.List;
import java.util.Optional;

import com.deasystem.restapi.com.modelo.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	public Optional<Usuario> find(Long id);
	public Usuario create(Usuario usuario);

}
