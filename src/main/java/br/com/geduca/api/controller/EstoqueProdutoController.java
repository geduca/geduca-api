package br.com.geduca.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.geduca.api.model.EstoqueProduto;
import br.com.geduca.api.model.RestricaoAlimentar;
import br.com.geduca.api.model.util.EstoqueProdutoUtil;
import br.com.geduca.api.service.EstoqueProdutoService;

/**
 * @author gustavoclay
 *
 */
@RestController
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/estoques_produtos")
public class EstoqueProdutoController {
	@Autowired
	private EstoqueProdutoService estoqueProdutoService;

	@GetMapping(value = "todos")
	public List<EstoqueProduto> listaTodos() {
		return estoqueProdutoService.listaTodos();
	}

	@GetMapping(value = "estoque")
	public List<EstoqueProduto> buscaPorEstoque(@RequestParam Long codigoEstoque) {
		return estoqueProdutoService.getByEstoque(codigoEstoque);
	}

	@GetMapping(value = "produto")
	public List<EstoqueProduto> buscaPorProduto(@RequestParam Long codigoProduto) {
		return estoqueProdutoService.getByProduto(codigoProduto);
	}

	@PostMapping
	public ResponseEntity<Object> criar(@RequestParam Long codigoEstoque,
			@RequestBody List<EstoqueProdutoUtil> produtos) {
		return estoqueProdutoService.save(codigoEstoque, produtos);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		estoqueProdutoService.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<EstoqueProduto> atualizar(@PathVariable Long codigo,
			@RequestBody EstoqueProduto estoqueProduto) {
		EstoqueProduto estoqueProdutoSalvo = estoqueProdutoService.atualizar(codigo, estoqueProduto);
		return ResponseEntity.ok(estoqueProdutoSalvo);
	}
}
