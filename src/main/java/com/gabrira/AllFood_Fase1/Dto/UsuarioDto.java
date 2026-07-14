package com.gabrira.AllFood_Fase1.Dto;

import com.gabrira.AllFood_Fase1.Model.TipoUsuario;
import com.gabrira.AllFood_Fase1.Model.Usuario;

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
