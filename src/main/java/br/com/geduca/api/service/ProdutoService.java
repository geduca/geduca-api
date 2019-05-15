package br.com.geduca.api.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.geduca.api.model.Aluno;
import br.com.geduca.api.model.FichaSaude;
import br.com.geduca.api.model.Pessoa;
import br.com.geduca.api.model.Produto;
import br.com.geduca.api.repository.FornecedorRepository;
import br.com.geduca.api.repository.ProdutoRepository;

/**
 * @author gustavoclay
 *
 */
@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FornecedorService fornecedorService;

	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto atualizar(Long codigo, Produto produto) {
//		Aluno alunoSalvo = buscaAlunoPeloCodigo(codigo);
//		Pessoa pessoaSalvo = pessoaService.buscarPessoaPeloCodigo(alunoSalvo.getPessoa().getCodigo());
//		FichaSaude fichaSaudeSalvo = fichaSaudeService.buscarFichaSaudePeloCodigo(alunoSalvo.getFichaSaude().getCodigo());
//		BeanUtils.copyProperties(produto, alunoSalvo, "codigo");
//		BeanUtils.copyProperties(produto.getPessoa(), pessoaSalvo, "codigo");
//		BeanUtils.copyProperties(produto.getFichaSaude(), fichaSaudeSalvo, "codigo");
//		fichaSaudeService.salvar(fichaSaudeSalvo);
//		pessoaService.salvar(pessoaSalvo);
//		return produtoRepository.save(alunoSalvo);
		return null;
	}

	public Produto buscaProdutoPeloCodigo(Long codigo) {
		Produto produtoSalvo = produtoRepository.getOne(codigo);
		if (produtoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return produtoSalvo;
	}

	public Page<Produto> findAll(Pageable pageable) {
		return produtoRepository.findAll(pageable);
	}

	public Optional<Produto> findById(long codigo) {
		return produtoRepository.findById(codigo);
	}

	public void deleteById(Long codigo) {
		produtoRepository.deleteById(codigo);
	}

}
