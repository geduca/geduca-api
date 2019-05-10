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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.geduca.api.model.AlunoRestricaoAlimentar;
import br.com.geduca.api.service.AlunoRestricaoAlimentarService;

/**
 * @author gustavoclay
 *
 */
@RestController
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/alunos_restricoes_alimentares")
public class AlunoRestricaoAlimentarController {

	@Autowired
	private AlunoRestricaoAlimentarService alunoRestricaoAlimentarService;

	@GetMapping
	public List<AlunoRestricaoAlimentar> buscaPorAluno(@RequestParam Long codigoAluno) {
		return alunoRestricaoAlimentarService.getByAluno(codigoAluno);
	}

	@PostMapping
	public ResponseEntity<AlunoRestricaoAlimentar> criar(@RequestBody AlunoRestricaoAlimentar alunoRestricaoAlimentar) {
		AlunoRestricaoAlimentar araSalva = alunoRestricaoAlimentarService.save(alunoRestricaoAlimentar);
		return ResponseEntity.status(HttpStatus.CREATED).body(araSalva);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		alunoRestricaoAlimentarService.deleteById(codigo);
	}

}
