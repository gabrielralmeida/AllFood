package com.gabrira.AllFood_Fase1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrira.AllFood_Fase1.Dto.UsuarioAlterarDadosDto;
import com.gabrira.AllFood_Fase1.Dto.UsuarioDto;
import com.gabrira.AllFood_Fase1.Service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alterar-dados-usuario")
@Tag(name = "Alterar Usuário", description = "Atualização de dados do usuário autenticado")
public class AlterarUsuarioController {
	
	@Autowired
	public UsuarioService service;
	
	@PutMapping
	@Operation(summary = "Alterar dados do usuário")
	public ResponseEntity<UsuarioDto> alterarDadosUsuario(@Valid @RequestBody UsuarioAlterarDadosDto user){
		service.atualizarDadosUsuario(user);
		var usuarioRetorno = service.consultaUsuarioPorEmail(user.email());
		return ResponseEntity.ok(usuarioRetorno);
	}

}
