package br.com.geduca.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.geduca.api.model.Aluno;
import br.com.geduca.api.model.AlunoRestricaoAlimentar;

/**
 * @author gustavoclay
 *
 */
@Repository
public interface AlunoResticaoAlimentarRepository extends JpaRepository<AlunoRestricaoAlimentar, Long> {
	
	@Query("select restricoes from AlunoRestricaoAlimentar restricoes where restricoes.aluno = :aluno")
	public List<AlunoRestricaoAlimentar> buscarTodosPorAluno(Aluno aluno);

}
