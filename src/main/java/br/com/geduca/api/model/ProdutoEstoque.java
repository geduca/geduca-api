package br.com.geduca.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe ProdutoEstoque
 * 
 * @author gustavoclay
 * 
 */

@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "rl_produto_estoque")
public class ProdutoEstoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto_estoque")
	private Long codigo;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private Estoque estoque;

	@ManyToOne
	private Unidade unidade;

	private Long quantidade;

	@Column(name = "quantidade_minima")
	private Long quantidadeMinima;

	private LocalDate dataRegistro;

}
