package com.gabrira.AllFood.Controller;

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

import com.gabrira.AllFood.Dto.LoginDTO;
import com.gabrira.AllFood.Dto.UsuarioAlteraSenhaDto;
import com.gabrira.AllFood.Model.Usuario;
import com.gabrira.AllFood.Security.TokenService;
import com.gabrira.AllFood.Service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<String> efetuarLogin(@RequestBody @Validated LoginDTO dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(tokenJWT);
    }
    
   	@PutMapping("/alterar-senha")
	public ResponseEntity<Void> alterarSenha(@Valid @RequestBody UsuarioAlteraSenhaDto user) {
   		service.atualizarSenha(user);
		return ResponseEntity.ok().build();
	}
    
}
