package br.com.geduca.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.geduca.api.model.Curso;
import br.com.geduca.api.model.Estoque;

/**
 * 
 * @author gustavoclay
 * 
 */
@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

	public Page<Estoque> findByNomeContaining(String nome, Pageable pageable);

}
