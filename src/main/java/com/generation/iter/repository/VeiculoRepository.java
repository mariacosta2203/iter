package com.generation.iter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.iter.model.VeiculoModel;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long>{

	public List<VeiculoModel> findAllByModeloContainingIgnoreCase(@Param("modelo") String modelo);
}
