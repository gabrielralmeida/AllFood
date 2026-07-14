package com.gabrira.AllFood_Fase1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabrira.AllFood_Fase1.Dto.UsuarioCadastroDTO;
import com.gabrira.AllFood_Fase1.Dto.UsuarioDto;
import com.gabrira.AllFood_Fase1.Service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuário", description = "Cadastro e consulta de usuários")
public class UsuarioController {
	
	@Autowired
	private UsuarioService userService;
	
	@PostMapping()
	@Transactional
	@Operation(summary = "Cadastrar usuário")
	@SecurityRequirements
	public ResponseEntity<UsuarioDto> cadastrar(@Valid @RequestBody UsuarioCadastroDTO req){
    	System.out.println(req);
		var usuario = userService.cadastrar(req);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping
	@Operation(summary = "Consultar usuários por nome")
	public ResponseEntity<Page<UsuarioDto>> consultaUsuarioPorNome(
			@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao,
			@RequestParam String nome) {
		var listaUsuario = userService.consultaUsuarioPorNome(paginacao, nome).map(UsuarioDto::new);
		return ResponseEntity.ok(listaUsuario);
	}

	@GetMapping("/todos")
	@Operation(summary = "Listar todos os usuários")
	public ResponseEntity<Page<UsuarioDto>> listarUsuarios(
			@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
		var listaUsuario = userService.listarUsuarios(paginacao).map(UsuarioDto::new);
		return ResponseEntity.ok(listaUsuario);
	}

}
