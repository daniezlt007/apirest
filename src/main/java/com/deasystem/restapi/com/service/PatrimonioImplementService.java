package com.deasystem.restapi.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deasystem.restapi.com.modelo.Patrimonio;
import com.deasystem.restapi.com.repository.PatrimonioRepository;

@Service
public class PatrimonioImplementService implements PatrimonioService {
	
	@Autowired
	private PatrimonioRepository patrimonioRepository;
	
	public PatrimonioImplementService(PatrimonioRepository patrimonioRepository) {
		super();
		this.patrimonioRepository = patrimonioRepository;
	}

	@Override
	public List<Patrimonio> findAll() {
		return (List<Patrimonio>) this.patrimonioRepository.findAll();
	}

	@Override
	public Optional<Patrimonio> find(Long id) {
		return this.patrimonioRepository.findById(id);
	}

	@Override
	public Patrimonio create(Patrimonio patrimonio) {
		return this.patrimonioRepository.save(patrimonio);
	}

	@Override
	public Patrimonio update(Long id, Patrimonio patrimonio) {
		Optional<Patrimonio> patrimonioExists = this.patrimonioRepository.findById(id);
		if(patrimonioExists != null) {
			patrimonio.setNumeroTombo(patrimonioExists.get().getNumeroTombo());
			this.patrimonioRepository.save(patrimonio);
			return patrimonio;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Optional<Patrimonio> produto = this.patrimonioRepository.findById(id);
		if(produto != null) {
			this.patrimonioRepository.deleteById(id);
		}
	}

}
