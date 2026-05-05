package com.gabrira.AllFood.Model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gabrira.AllFood.Dto.UsuarioAlterarDadosDto;
import com.gabrira.AllFood.Dto.UsuarioCadastroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@NotBlank(message = "O e-mail precisa ser informado.")
	@Email(message = "E-mail invalido")
	private String email;
	private String senha;
	private String userlogin;
    @Enumerated(EnumType.STRING)
	private TipoUsuario tipousuario;
	private LocalDateTime dataatualizacao;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	public Usuario() {}
	
	public Usuario(UsuarioCadastroDTO usuario) {
		this.nome = usuario.nome();
		this.senha = usuario.senha();
		this.email = usuario.email();
		this.userlogin = usuario.userlogin();
		this.tipousuario = TipoUsuario.valueOf(usuario.tipousuario().toUpperCase());
		this.dataatualizacao = LocalDateTime.now();
		this.endereco = new Endereco(usuario.endereco());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getUserlogin() {
		return this.userlogin;
	}

	public TipoUsuario getTipousuario() {
		return this.tipousuario;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public LocalDateTime getDataAtualizacao() {
		return this.dataatualizacao;
	}
	
	public void atualizarSenha(String senha) {
		this.senha = senha;
		this.dataatualizacao = LocalDateTime.now(); 
	}
	
	public void atualizarDadosUsuario(UsuarioAlterarDadosDto user) {
		this.nome = user.nome();
		this.tipousuario = user.tipoUsuario();
		this.dataatualizacao = LocalDateTime.now();
		if (user.endereco() != null) {
			if (this.endereco != null) {
				this.endereco.atualizarDadosEndereco(user.endereco());
			} else {
				this.endereco = new Endereco(user.endereco());
			}
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public @Nullable String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}
	
	

}
