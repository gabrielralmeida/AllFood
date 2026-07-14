package com.gabrira.AllFood_Fase1.Dto;

import org.jspecify.annotations.Nullable;

import com.gabrira.AllFood_Fase1.Model.Endereco;

public record EnderecoDto(
		Long id,
		String cep,
		String logradouro,
		Integer numero,
		String cidade,
		String estado,
		String uf
		) {

	public static @Nullable EnderecoDto from(Endereco endereco) {
		if (endereco == null) {
			return null;
		}
		return new EnderecoDto(
				endereco.getId(),
				endereco.getCep(),
				endereco.getLogradouro(),
				endereco.getNumero(),
				endereco.getCidade(),
				endereco.getEstado(),
				endereco.getUf());
	}
}
