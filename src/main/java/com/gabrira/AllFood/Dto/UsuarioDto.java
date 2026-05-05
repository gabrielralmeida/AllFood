package com.gabrira.AllFood.Dto;

import com.gabrira.AllFood.Model.TipoUsuario;
import com.gabrira.AllFood.Model.Usuario;

public record UsuarioDto(
		Long id,
		String nome,
		String email,
		String userLogin,
		TipoUsuario tipousuario,
		EnderecoDto endereco) {

	public UsuarioDto(Usuario user) {
		this(
				user.getId(),
				user.getNome(),
				user.getEmail(),
				user.getUserlogin(),
				user.getTipousuario(),
				EnderecoDto.from(user.getEndereco()));
	}
}
