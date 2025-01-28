package com.generation.iter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.iter.model.UsuarioModel;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
	public Optional<UsuarioModel> findByUsuario(@Param("usuario")String usuario);

}
