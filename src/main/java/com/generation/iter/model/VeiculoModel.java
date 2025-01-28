package com.generation.iter.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_veiculo")
public class VeiculoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo Modelo é obrigatório!")
	@Size(min = 5, max = 50, message = "O atributo deve conter no mínimo 5 e no máximo 50 caracteres")
	private String modelo;
	
	@NotBlank(message = "O atributo Marca é obrigatório!")
	@Size(min = 5, max = 50, message = "O atributo deve conter no mínimo 5 e no máximo 50 caracteres")
	private String marca;
	
	@NotBlank(message = "O atributo Cor é obrigatório!")
	@Size(min = 4, max = 50, message = "O atributo deve conter no mínimo 5 e no máximo 50 caracteres")
	private String cor;
	
	@NotBlank(message = "O atributo Placa é obrigatório!")
	@Size(min = 7, max = 7, message = "O atributo deve conter no mínimo 5 e no máximo 50 caracteres")
	private String placa;
	
	@NotBlank(message = "O atributo Motorista é obrigatório!")
	@Size(min = 5, max = 50, message = "O atributo deve conter no mínimo 5 e no máximo 50 caracteres")
	private String motorista;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "veiculo", cascade = CascadeType.REMOVE)
	private List<ViagemModel> viagem;  

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	public List<ViagemModel> getViagem() {
		return viagem;
	}

	public void setViagem(List<ViagemModel> viagem) {
		this.viagem = viagem;
	} 
	
	
	
}
