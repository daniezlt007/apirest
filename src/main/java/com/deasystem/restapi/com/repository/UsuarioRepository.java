package com.deasystem.restapi.com.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deasystem.restapi.com.modelo.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u where u.email=?1")
	Usuario findByEmailAddress(String email);
	
}
