package br.com.geduca.api.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.geduca.api.model.Aluno;
import br.com.geduca.api.model.Pessoa;
import br.com.geduca.api.repository.AlunoRepository;

/**
 * @author gustavoclay
 *
 */
@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private PessoaService pessoaService;

	public Aluno salvar(Aluno aluno) {
		LocalDate data = LocalDate.now();
		aluno.setDataMatricula(data);
		pessoaService.salvar(aluno.getPessoa());
		return alunoRepository.save(aluno);
	}

	public Aluno atualizar(Long codigo, Aluno aluno) {
		Aluno alunoSalvo = buscaAlunoPeloCodigo(codigo);
		Pessoa pessoaSalvo = pessoaService.buscarPessoaPeloCodigo(alunoSalvo.getPessoa().getCodigo());
		BeanUtils.copyProperties(aluno.getPessoa(), pessoaSalvo, "codigo");
		BeanUtils.copyProperties(aluno, alunoSalvo, "codigo");
		pessoaService.salvar(pessoaSalvo);
		return alunoRepository.save(alunoSalvo);
	}

	public Aluno buscaAlunoPeloCodigo(Long codigo) {
		Aluno alunoSalvo = alunoRepository.getOne(codigo);
		if (alunoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return alunoSalvo;
	}

	public Page<Aluno> findAll(Pageable pageable) {
		return alunoRepository.findAll(pageable);
	}

	public Optional<Aluno> findById(Long codigo) {
		return alunoRepository.findById(codigo);
	}

	public void deleteById(Long codigo) {
		alunoRepository.deleteById(codigo);
	}

}
