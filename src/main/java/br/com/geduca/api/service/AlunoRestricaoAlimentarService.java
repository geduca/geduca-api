package br.com.geduca.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geduca.api.model.Aluno;
import br.com.geduca.api.model.AlunoRestricaoAlimentar;
import br.com.geduca.api.repository.AlunoResticaoAlimentarRepository;

/**
 * @author gustavoclay
 *
 */
@Service
public class AlunoRestricaoAlimentarService {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AlunoResticaoAlimentarRepository alunoRestricaoAlimentarRepository;

	public AlunoRestricaoAlimentar save(AlunoRestricaoAlimentar alunoRestricaoAlimentar) {
		return alunoRestricaoAlimentarRepository.save(alunoRestricaoAlimentar);
	}

	public void deleteById(Long codigo) {
		alunoRestricaoAlimentarRepository.deleteById(codigo);
	}

	public List<AlunoRestricaoAlimentar> getByAluno(Long codigoAluno) {
		Aluno aluno = alunoService.buscaAlunoPeloCodigo(codigoAluno);
		if (aluno != null) {
			return alunoRestricaoAlimentarRepository.buscarTodosPorAluno(aluno);
		}
		return null;
	}
}
