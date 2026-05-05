package com.gabrira.AllFood.Dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioCadastroDTO(
		@NotBlank String nome, 
		@NotBlank String email, 
		@NotNull String senha, 
		@NotBlank String userlogin, 
		@NotBlank String tipousuario,
		@NotNull @Valid EnderecoDto endereco
		) {}
