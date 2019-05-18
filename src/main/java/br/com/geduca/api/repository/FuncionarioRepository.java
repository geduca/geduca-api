package br.com.geduca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geduca.api.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
