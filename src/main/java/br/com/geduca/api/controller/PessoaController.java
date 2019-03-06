package br.com.geduca.api.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.geduca.api.model.Pessoa;
import br.com.geduca.api.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public Page<Pessoa> pesquisar(@RequestParam(required = false, defaultValue = "%") String nome,
			@RequestParam int pagina, @RequestParam int max) {
		return pessoaService.findByNomeContaining(nome, pagina, max);
	}

	@PostMapping
	public ResponseEntity<String> criar(@RequestBody Pessoa pessoa, HttpServletResponse response) {
		try {
			pessoaService.salvar(pessoa);

		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao adicionar a pessoa" + pessoa.getNome(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Pessoa " + pessoa.getNome() + " adicionada com sucesso !");
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscaPeloCodigo(@PathVariable Long codigo) {
		Optional<Pessoa> pessoa =  pessoaService.findById(codigo);
		if (pessoa.isPresent()) {
			return ResponseEntity.ok(pessoa.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		try {
			pessoaService.deleteById(codigo);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(HttpStatus.OK).body("Pessoa de código" + codigo + " deletada com sucesso !");
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
		try {
			pessoaService.atualizar(codigo, pessoa);
		} catch (Exception e) {
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(pessoa);
	}

	@PutMapping("/{codigo}/ativo")
	public ResponseEntity<String> atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		try {
			pessoaService.atualizarPropriedadeAtivo(codigo, ativo);

		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao atualizar", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok("Atualizado com sucesso !");
	}

}
