package com.deasystem.restapi.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deasystem.restapi.com.modelo.Marca;
import com.deasystem.restapi.com.repository.MarcaRepository;

@Service
public class MarcaImplementService implements MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public List<Marca> findAll() {
		return (List<Marca>) this.marcaRepository.findAll();
	}

	@Override
	public Optional<Marca> find(Long id) {
		return this.marcaRepository.findById(id);
	}

	@Override
	public Marca create(Marca marca) {
		return this.marcaRepository.save(marca);
	}

	@Override
	public Marca update(Long id, Marca marca) {
		Optional<Marca> marcaExists = this.marcaRepository.findById(id);
		if(marcaExists != null) {
			marca.setMarcaId(marcaExists.get().getMarcaId());
			this.marcaRepository.save(marca);
			return marca;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Optional<Marca> marca = this.marcaRepository.findById(id);
		if(marca != null) {
			this.marcaRepository.deleteById(id);
		}
	}

}
