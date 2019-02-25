package br.com.geduca.api.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.geduca.api.model.Pessoa;
import br.com.geduca.api.repository.PessoaRepository;
import br.com.geduca.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public Page<Pessoa> pesquisar(@RequestParam(required = false, defaultValue = "%") String nome,
			Pageable pageable) {
		return pessoaRepository.findByNomeContaining(nome, pageable);
	}

	@PostMapping
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = pessoaService.salvar(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

}
