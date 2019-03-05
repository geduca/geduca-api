package br.com.geduca.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Entity(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long codigo;

	private String nome;

	private String descricao;

	private Long quantidade;

	private Unidade unidade;

	@Column(name = "quantidade_minima")
	private Long quantidadeMinima;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_validade")
	private LocalDate dataValidade;

	@ManyToMany
	private Fornecedor fornecedor;

}
