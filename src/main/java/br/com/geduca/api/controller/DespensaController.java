package br.com.geduca.api.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import br.com.geduca.api.model.Estoque;
import br.com.geduca.api.service.EstoqueService;

/**
 * @author gustavoclay
 *
 */
@RestController
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;

	@GetMapping
	public Page<Estoque> pesquisar(@RequestParam(required = false, defaultValue = "%") String nome,
			@RequestParam int pagina, @RequestParam int max) {
		return estoqueService.findByNomeContaining(nome, PageRequest.of(pagina, max));
	}

	@GetMapping(value = "lista")
	public List<Estoque> listarTodos() {
		return estoqueService.findAllList();
	}

	@PostMapping
	public ResponseEntity<Estoque> criar(@RequestBody Estoque estoque, HttpServletResponse response) {
		Estoque estoqueSalvo = estoqueService.salvar(estoque);
		return ResponseEntity.status(HttpStatus.CREATED).body(estoqueSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Estoque>> buscaPeloCodigo(@PathVariable Long codigo) {
		Optional<Estoque> estoque = estoqueService.findById(codigo);
		if (estoque != null)
			return ResponseEntity.ok(estoque);
		else
			return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		estoqueService.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Estoque> atualizar(@PathVariable Long codigo, @RequestBody Estoque estoque) {
		Estoque estoqueSalvo = estoqueService.atualizar(codigo, estoque);
		return ResponseEntity.ok(estoqueSalvo);
	}

}
