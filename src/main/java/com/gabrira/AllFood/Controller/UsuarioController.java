package com.gabrira.AllFood.Controller;

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

import com.gabrira.AllFood.Dto.UsuarioCadastroDTO;
import com.gabrira.AllFood.Dto.UsuarioDto;
import com.gabrira.AllFood.Service.UsuarioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService userService;
	
	@PostMapping()
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@Valid @RequestBody UsuarioCadastroDTO req){
    	System.out.println(req);
		var usuario = userService.cadastrar(req);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping
	public ResponseEntity<Page<UsuarioDto>> consultaUsuarioPorNome(
			@PageableDefault(size=10, sort= {"nome"}) Pageable paginacao,
			@RequestParam String nome){
		System.out.println("\nconsultaUsuarioPorNome" + nome);
		var listaUsuario = userService.consultaUsuarioPorNome(paginacao, nome).map(UsuarioDto::new);
		return ResponseEntity.ok(listaUsuario);
	}

}
