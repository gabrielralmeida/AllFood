package com.gabrira.AllFood_Fase1.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoCadastroDTO(
		@NotBlank(message = "O CEP precisa ser informado.")
		String cep,
		@NotBlank(message = "O logradouro precisa ser informado.")
		String logradouro,
		@NotNull(message = "O número precisa ser informado.")
		Integer numero,
		@NotBlank(message = "A cidade precisa ser informada.")
		String cidade,
		@NotBlank(message = "O estado precisa ser informado.")
		String estado,
		@NotBlank(message = "A UF precisa ser informada.")
		String uf
		) {
}
