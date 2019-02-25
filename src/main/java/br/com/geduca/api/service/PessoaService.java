package br.com.geduca.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geduca.api.model.Pessoa;
import br.com.geduca.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
}
