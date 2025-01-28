package com.generation.iter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_viagem")
public class ViagemModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O Destino é obrigatório!")
	@Size(min=1, max=200, message="O campo Destino deve ter no mínimo 1 e no máximo 100 caracteres.")
	private String destino;
	
	@NotNull(message = "O Atributo Origem é obrigatório!")
	@Size(min=1, max=200, message="O campo Origem deve ter no mínimo 1 e no máximo 500 caracteres.")
	private String origem;
	
	@NotNull(message = "O campo Preço é obrigatório!")
	private Double preco;
	
	@NotNull(message = "O campo Distância é obrigatório!")
	private Double distancia;
	
	@NotNull(message = "O campo Velocidade Media é obrigatório!")
	private Double velMedia;
	
	@ManyToOne
	@JsonIgnoreProperties("viagem")
	private VeiculoModel veiculo;
	
	@ManyToOne
	@JsonIgnoreProperties("viagem")
	private UsuarioModel usuario;
	
	private String tempoViagem;
	
	
	public String getTempoViagem() {
		return tempoViagem;
	}

	public void setTempoViagem(String tempoViagem) {
		this.tempoViagem = tempoViagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Double getVelMedia() {
		return velMedia;
	}

	public void setVelMedia(Double velMedia) {
		this.velMedia = velMedia;
	}

	public VeiculoModel getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoModel veiculo) {
		this.veiculo = veiculo;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
}
