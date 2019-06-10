package br.com.geduca.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.geduca.api.model.Estoque;
import br.com.geduca.api.model.EstoqueProduto;
import br.com.geduca.api.model.Produto;
import br.com.geduca.api.model.util.EstoqueProdutoUtil;
import br.com.geduca.api.repository.EstoqueProdutoRepository;

/**
 * @author gustavoclay
 *
 */
@Service
public class EstoqueProdutoService {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private EstoqueService estoqueService;

	@Autowired
	private EstoqueProdutoRepository estoqueProdutoRepository;

	public ResponseEntity<Object> save(Long codigoEstoque, List<EstoqueProdutoUtil> produtos) {
		Estoque estoque = estoqueService.buscarEstoquePeloCodigo(codigoEstoque);
		if (estoque != null) {
			if (!produtos.isEmpty()) {
				produtos.forEach(produto -> {
					EstoqueProduto estoqueProduto = new EstoqueProduto();
					estoqueProduto.setEstoque(estoque);
					estoqueProduto.setProduto(produto.getProduto());
					estoqueProduto.setQuantidade(produto.getQuantidade());
					estoqueProduto.setQuantidadeMinima(produto.getQuantidadeMinima());
					estoqueProduto.setDataRegistro(LocalDate.now());
					estoqueProdutoRepository.save(estoqueProduto);
				});
				return ResponseEntity.ok().build();
			}
		}
		return ResponseEntity.badRequest().build();
	}

	public EstoqueProduto atualizar(Long codigo, EstoqueProduto estoqueProduto) {
		estoqueProduto.setDataRegistro(LocalDate.now());
		EstoqueProduto estoqueProdutoSalvo = buscarEstoqueProdutoPeloCodigo(codigo);
		BeanUtils.copyProperties(estoqueProduto, estoqueProdutoSalvo, "codigo");
		return estoqueProdutoRepository.save(estoqueProdutoSalvo);
	}

	public EstoqueProduto buscarEstoqueProdutoPeloCodigo(Long codigo) {
		EstoqueProduto estoqueProduto = estoqueProdutoRepository.getOne(codigo);
		if (estoqueProduto == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return estoqueProduto;
	}

	public void deleteById(Long codigo) {
		estoqueProdutoRepository.deleteById(codigo);
	}

	public List<EstoqueProduto> listaTodos() {
		return estoqueProdutoRepository.findAll();
	}

	public List<EstoqueProduto> getByEstoque(Long codigoEstoque) {
		Estoque estoque = estoqueService.buscarEstoquePeloCodigo(codigoEstoque);
		if (estoque != null) {
			return estoqueProdutoRepository.findAllByEstoque(estoque);
		}
		return null;
	}

	public List<EstoqueProduto> getByProduto(Long codigoProduto) {
		Produto produto = produtoService.buscaProdutoPeloCodigo(codigoProduto);
		if (produto != null) {
			return estoqueProdutoRepository.findAllByProduto(produto);
		}
		return null;
	}

}
