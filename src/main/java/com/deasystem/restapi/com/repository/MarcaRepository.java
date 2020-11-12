package com.deasystem.restapi.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deasystem.restapi.com.modelo.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long> {

}
