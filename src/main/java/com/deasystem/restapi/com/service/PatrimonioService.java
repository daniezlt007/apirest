package com.deasystem.restapi.com.service;

import java.util.List;
import java.util.Optional;

import com.deasystem.restapi.com.modelo.Patrimonio;

public interface PatrimonioService {
	
	public List<Patrimonio> findAll();
	public Optional<Patrimonio> find(Long id);
	public Patrimonio create(Patrimonio patrimonio);
	public Patrimonio update(Long id, Patrimonio patrimonio);
	public void delete(Long id);
	
}
