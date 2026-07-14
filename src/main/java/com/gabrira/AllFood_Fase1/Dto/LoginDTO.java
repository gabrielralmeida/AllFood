package com.gabrira.AllFood_Fase1.Dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String email, @NotBlank String senha) {
	
}

