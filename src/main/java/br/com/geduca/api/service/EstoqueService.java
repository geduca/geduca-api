package br.com.geduca.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.geduca.api.model.Estoque;
import br.com.geduca.api.repository.EstoqueRepository;

/**
 * 
 * @author gustavoclay
 * 
 */
@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;

	public Estoque salvar(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	public Estoque atualizar(Long codigo, Estoque estoque) {
		Estoque estoqueSalvo = buscarEstoquePeloCodigo(codigo);
		BeanUtils.copyProperties(estoque, estoqueSalvo, "codigo");
		return estoqueRepository.save(estoqueSalvo);
	}

	public Estoque buscarEstoquePeloCodigo(Long codigo) {
		Estoque estoqueSalvo = estoqueRepository.getOne(codigo);
		if (estoqueSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return estoqueSalvo;
	}

	public Page<Estoque> findByNomeContaining(String nome, Pageable paginacao) {
		return estoqueRepository.findByNomeContaining(nome, paginacao);
	}
	
	public List<Estoque> findAllList() {
		return estoqueRepository.findAll();
	}

	public Optional<Estoque> findById(Long codigo) {
		return estoqueRepository.findById(codigo);
	}

	public void deleteById(Long codigo) {
		estoqueRepository.deleteById(codigo);
	}
}
