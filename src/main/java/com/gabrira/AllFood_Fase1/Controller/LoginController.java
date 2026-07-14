package com.gabrira.AllFood_Fase1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrira.AllFood_Fase1.Dto.LoginDTO;
import com.gabrira.AllFood_Fase1.Dto.UsuarioAlteraSenhaDto;
import com.gabrira.AllFood_Fase1.Model.Usuario;
import com.gabrira.AllFood_Fase1.Security.TokenService;
import com.gabrira.AllFood_Fase1.Service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("login")
@Tag(name = "Login", description = "Autenticação e alteração de senha")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService service;

    @PostMapping
    @Operation(summary = "Efetuar login e obter token JWT")
    @SecurityRequirements
    public ResponseEntity<String> efetuarLogin(@RequestBody @Validated LoginDTO dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(tokenJWT);
    }
    
   	@PutMapping("/alterar-senha")
   	@Operation(summary = "Alterar senha do usuário")
	public ResponseEntity<Void> alterarSenha(@Valid @RequestBody UsuarioAlteraSenhaDto user) {
   		service.atualizarSenha(user);
		return ResponseEntity.ok().build();
	}
    
}
