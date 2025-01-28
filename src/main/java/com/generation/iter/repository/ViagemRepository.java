package com.generation.iter.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.generation.iter.model.ViagemModel;

public interface ViagemRepository extends JpaRepository<ViagemModel, Long>{

	public List <ViagemModel> findAllByDestinoContainingIgnoreCase(@Param("destino") String destino);
}
