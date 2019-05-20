package br.com.geduca.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.geduca.api.model.Estoque;
import br.com.geduca.api.model.EstoqueProduto;
import br.com.geduca.api.model.Produto;

/**
 * @author gustavoclay
 *
 */
@Repository
public interface EstoqueProdutoRepository extends JpaRepository<EstoqueProduto, Long> {

	List<EstoqueProduto> findAllByEstoque(Estoque estoque);

	List<EstoqueProduto> findAllByProduto(Produto produto);
}
