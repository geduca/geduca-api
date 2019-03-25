package br.com.geduca.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.geduca.api.model.Aluno;
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
		pessoaService.salvar(aluno.getPessoa());
		return alunoRepository.save(aluno);
	}

	public Aluno atualizar(Long codigo, Aluno aluno) {
		Aluno alunoSalvo = buscaAlunoPeloCodigo(codigo);
		BeanUtils.copyProperties(aluno, alunoSalvo, "codigo");
		return alunoRepository.save(alunoSalvo);
	}

	public Aluno buscaAlunoPeloCodigo(Long codigo) {
		Aluno alunoSalvo = alunoRepository.getOne(codigo);
		if (alunoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return alunoSalvo;
	}
}
