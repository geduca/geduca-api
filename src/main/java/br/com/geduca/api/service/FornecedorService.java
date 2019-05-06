package br.com.geduca.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.geduca.api.model.Fornecedor;
import br.com.geduca.api.repository.FornecedorRepository;

/**
 * @author gustavoclay
 *
 */
@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository FornecedorRepository;

	public Fornecedor salvar(Fornecedor fornecedor) {
		return FornecedorRepository.save(fornecedor);
	}

	public Fornecedor atualizar(Long codigo, Fornecedor fornecedor) {
//		Aluno alunoSalvo = buscaAlunoPeloCodigo(codigo);
//		Pessoa pessoaSalvo = pessoaService.buscarPessoaPeloCodigo(alunoSalvo.getPessoa().getCodigo());
//		BeanUtils.copyProperties(aluno.getPessoa(), pessoaSalvo, "codigo");
//		BeanUtils.copyProperties(aluno, alunoSalvo, "codigo");
//		pessoaService.salvar(pessoaSalvo);
//		return FornecedorRepository.save(alunoSalvo);
		return null;
	}

	public Fornecedor buscaFornecedorPeloCodigo(Long codigo) {
		Fornecedor fornecedorSalvo = FornecedorRepository.getOne(codigo);
		if (fornecedorSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return fornecedorSalvo;
	}

	public Page<Fornecedor> findAll(Pageable pageable) {
		return FornecedorRepository.findAll(pageable);
	}

	public Optional<Fornecedor> findById(long codigo) {
		return FornecedorRepository.findById(codigo);
	}

	public void deleteById(Long codigo) {
		FornecedorRepository.deleteById(codigo);
	}

}
