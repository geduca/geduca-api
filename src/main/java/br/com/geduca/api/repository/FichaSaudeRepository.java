package br.com.geduca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geduca.api.model.FichaSaude;

/**
 * @author gustavoclay
 *
 */
public interface FichaSaudeRepository extends JpaRepository<FichaSaude, Long> {

}
