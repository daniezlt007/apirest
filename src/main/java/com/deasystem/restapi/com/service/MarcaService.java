package com.deasystem.restapi.com.service;

import java.util.List;
import java.util.Optional;

import com.deasystem.restapi.com.modelo.Marca;

public interface MarcaService {
	
	public List<Marca> findAll();
	public Optional<Marca> find(Long id);
	public Marca create(Marca marca);
	public Marca update(Long id, Marca marca);
	public void delete(Long id);

}
