package br.com.geduca.api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Produto
 * 
 * @author gustavoclay
 * 
 */

@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long codigo;

	private String nome;

	private String descricao;

	private Long quantidade;

	@Column(name = "quantidade_minima")
	private Long quantidadeMinima;

	@Column(name = "dt_validade")
	private LocalDate dataValidade;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	@JoinTable(name = "rl_produto_fornecedor")
	private List<Fornecedor> fornecedores;

}
