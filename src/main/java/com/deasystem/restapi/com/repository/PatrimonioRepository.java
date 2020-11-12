package com.deasystem.restapi.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deasystem.restapi.com.modelo.Patrimonio;

@Repository
public interface PatrimonioRepository extends CrudRepository<Patrimonio, Long> {

}
