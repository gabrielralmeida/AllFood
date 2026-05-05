package com.gabrira.AllFood.Dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String email, @NotBlank String senha) {
	
}

