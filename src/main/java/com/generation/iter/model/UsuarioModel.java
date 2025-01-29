package com.generation.iter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull(message = "O Atributo Nome é Obrigatório!")
		private String nome;
		
		
		@Schema(example = "email@email.com.br")
		@NotNull(message = "O Atributo Usuário é Obrigatório!")
		@Email(message = "O Atributo Usuário deve ser um email válido!")
		private String usuario;
		

		@NotBlank(message = "O Atributo Senha é Obrigatório!")
		@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
		private String senha;

		@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("usuario")
		private List<ViagemModel> viagem;
		
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public List<ViagemModel> getViagem() {
			return viagem;
		}

		public void setViagem(List<ViagemModel> viagem) {
			this.viagem = viagem;
		}
		
		
}
