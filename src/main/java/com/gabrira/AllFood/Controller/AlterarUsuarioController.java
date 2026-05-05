package com.gabrira.AllFood.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrira.AllFood.Dto.UsuarioAlterarDadosDto;
import com.gabrira.AllFood.Dto.UsuarioDto;
import com.gabrira.AllFood.Service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alterar-dados-usuario")
public class AlterarUsuarioController {
	
	@Autowired
	public UsuarioService service;
	
	@PutMapping
	public ResponseEntity<UsuarioDto> alterarDadosUsuario(@Valid @RequestBody UsuarioAlterarDadosDto user){
		service.atualizarDadosUsuario(user);
		var usuarioRetorno = service.consultaUsuarioPorEmail(user.email());
		return ResponseEntity.ok(usuarioRetorno);
	}

}
