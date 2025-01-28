package com.generation.iter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.iter.model.ViagemModel;
import com.generation.iter.repository.UsuarioRepository;
import com.generation.iter.repository.VeiculoRepository;
import com.generation.iter.repository.ViagemRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/viagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ViagemController {

	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<ViagemModel>> getAll()
	{
		return ResponseEntity.ok(viagemRepository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ViagemModel> getById(@PathVariable Long id)
	{
		return viagemRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/destino/{destino}")
	public ResponseEntity<List<ViagemModel>> getByDestino(@PathVariable String destino)
	{
		return ResponseEntity.ok(viagemRepository.findAllByDestinoContainingIgnoreCase(destino));
	}
	
	@PostMapping("/criar")
	public ResponseEntity<ViagemModel> post(@Valid @RequestBody ViagemModel viagem)
	{
		if(veiculoRepository.existsById(viagem.getVeiculo().getId()) && usuarioRepository.existsById(viagem.getUsuario().getId()))
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(viagemRepository.save(viagem));		
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Veículo não existe!", null);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<ViagemModel> put(@Valid @RequestBody ViagemModel viagem)
	{
		if(viagemRepository.existsById(viagem.getId()))
		{
			if(veiculoRepository.existsById(viagem.getVeiculo().getId()) && usuarioRepository.existsById(viagem.getUsuario().getId()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(viagemRepository.save(viagem));
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Veículo não existe!", null);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/deletar/{id}")
	public void delete(@PathVariable Long id)
	{
		Optional<ViagemModel> postagem = viagemRepository.findById(id);
		
		if(postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		viagemRepository.deleteById(id);
	}
}
