package com.gabrira.AllFood_Fase1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrira.AllFood_Fase1.Dto.EnderecoCadastroDTO;
import com.gabrira.AllFood_Fase1.Dto.EnderecoDto;
import com.gabrira.AllFood_Fase1.Service.EnderecoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/endereco")
@Tag(name = "Endereço", description = "Cadastro e manutenção de endereços")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@PostMapping
	@Transactional
	@Operation(summary = "Cadastrar endereço")
	public ResponseEntity<EnderecoDto> cadastrar(@Valid @RequestBody EnderecoCadastroDTO req) {
		return ResponseEntity.ok(enderecoService.cadastrar(req));
	}

	@GetMapping("/{id}")
	@Operation(summary = "Buscar endereço por ID")
	public ResponseEntity<EnderecoDto> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(enderecoService.buscarPorId(id));
	}

	@PutMapping("/{id}")
	@Transactional
	@Operation(summary = "Atualizar endereço")
	public ResponseEntity<EnderecoDto> atualizar(@PathVariable Long id, @Valid @RequestBody EnderecoCadastroDTO req) {
		return ResponseEntity.ok(enderecoService.atualizar(id, req));
	}

}
