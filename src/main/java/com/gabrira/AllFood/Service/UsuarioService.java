package com.gabrira.AllFood.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gabrira.AllFood.Dto.UsuarioAlteraSenhaDto;
import com.gabrira.AllFood.Dto.UsuarioAlterarDadosDto;
import com.gabrira.AllFood.Dto.UsuarioCadastroDTO;
import com.gabrira.AllFood.Dto.UsuarioDto;
import com.gabrira.AllFood.Exception.ValidacaoException;
import com.gabrira.AllFood.Repository.IUsuarioRepository;
import com.gabrira.AllFood.Speficication.UsuarioSpecification;
import com.gabrira.AllFood.Model.Usuario;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
    private IUsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.repository.findByEmail(email);
    }
    
    public UsuarioDto cadastrar(UsuarioCadastroDTO dto) {
    	var jaCadastrado = repository.findByEmail(dto.email());
    	if (jaCadastrado != null) {
    		throw new ValidacaoException("E-mail já cadastrado.");
    	}
    	
    	var user = new Usuario(dto);
    	user.setSenha(passwordEncoder.encode(dto.senha()));
    	repository.save(user);
    	return new UsuarioDto(user);
    }
    
    @Transactional
    public void atualizarSenha(UsuarioAlteraSenhaDto user) {
    	var usuario = repository.findByUserlogin(user.userlogin());
    	System.out.println("usuario: " + usuario.getEmail());
    	System.out.println("user: " + user.email());
    	
    	if (usuario != null) {
    		if (usuario.getEmail().equals(user.email())) {
    			System.out.println("vai alterar os dados");
        		usuario.atualizarSenha(passwordEncoder.encode(user.senha()));
        		return;
    		}
    		//nesse ponto seria preciso retornar uma exceção pois o login é diferente para o email informado
    		throw new RuntimeException("Dados de acesso inválido");
    	}
    }
    
    @Transactional
    public void atualizarDadosUsuario(UsuarioAlterarDadosDto user) {
    	var usuario = repository.findByEmail(user.email());
    	if (usuario != null) {
    		usuario.atualizarDadosUsuario(user);
    	}
    }
    
    public UsuarioDto consultaUsuarioPorEmail(String email) {
    	var usuario = repository.findByEmail(email);
    	UsuarioDto dto = new UsuarioDto(usuario);
    	return dto;
    }
    
    public Page<Usuario> consultaUsuarioPorNome(Pageable paginacao, String nome) {
    	Specification<Usuario> spec = Specification.where(UsuarioSpecification.porNome(nome));
    	return repository.findAll(spec, paginacao);
    }
}
