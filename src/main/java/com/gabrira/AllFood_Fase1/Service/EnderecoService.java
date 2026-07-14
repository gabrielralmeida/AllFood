package com.gabrira.AllFood_Fase1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gabrira.AllFood_Fase1.Dto.EnderecoCadastroDTO;
import com.gabrira.AllFood_Fase1.Dto.EnderecoDto;
import com.gabrira.AllFood_Fase1.Model.Endereco;
import com.gabrira.AllFood_Fase1.Repository.IEnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private IEnderecoRepository repository;

	public EnderecoDto cadastrar(EnderecoCadastroDTO dto) {
		var endereco = new Endereco(dto);
		repository.save(endereco);
		return EnderecoDto.from(endereco);
	}

	public EnderecoDto buscarPorId(Long id) {
		return EnderecoDto.from(buscarEntidadePorId(id));
	}

	public EnderecoDto atualizar(Long id, EnderecoCadastroDTO dto) {
		var endereco = buscarEntidadePorId(id);
		endereco.atualizarDadosEndereco(dto);
		repository.save(endereco);
		return EnderecoDto.from(endereco);
	}

	private Endereco buscarEntidadePorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado."));
	}

}
