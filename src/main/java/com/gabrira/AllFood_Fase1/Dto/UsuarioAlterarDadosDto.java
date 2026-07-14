package com.gabrira.AllFood_Fase1.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabrira.AllFood_Fase1.Model.TipoUsuario;

import jakarta.validation.Valid;

public record UsuarioAlterarDadosDto(
		String email,
		String nome,
		TipoUsuario tipoUsuario,
		@JsonProperty(required = false) @Valid EnderecoDto endereco) {

}
