package br.com.geduca.api.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.geduca.api.model.Estoque;

@Repository
public interface EstoqueRepositoryCustom {

	Page<Estoque> listarEstoquePorDespensa(Pageable paginacao);

}
