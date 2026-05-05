package com.gabrira.AllFood.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabrira.AllFood.Model.TipoUsuario;

import jakarta.validation.Valid;

public record UsuarioAlterarDadosDto(
		String email,
		String nome,
		TipoUsuario tipoUsuario,
		@JsonProperty(required = false) @Valid EnderecoDto endereco) {

}
