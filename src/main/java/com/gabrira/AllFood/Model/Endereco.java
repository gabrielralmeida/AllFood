package com.gabrira.AllFood.Model;

import java.time.LocalDateTime;

import com.gabrira.AllFood.Dto.EnderecoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private String logradouro;
	private Integer numero;
	private String cidade;
	private String estado;
	private String uf;
	private LocalDateTime dataatualizacao;

	public Endereco() {}
	
	public Endereco(EnderecoDto endereco) {
		this.cep = endereco.cep();
		this.logradouro = endereco.logradouro();
		this.numero = endereco.numero();
		this.cidade = endereco.cidade();
		this.estado = endereco.estado();
		this.uf = endereco.uf();
		this.dataatualizacao = LocalDateTime.now();
	}

	public void atualizarDadosEndereco(EnderecoDto endereco) {
		this.cep = endereco.cep();
		this.logradouro = endereco.logradouro();
		this.numero = endereco.numero();
		this.cidade = endereco.cidade();
		this.estado = endereco.estado();
		this.uf = endereco.uf();
		this.dataatualizacao = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getUf() {
		return uf;
	}
}
