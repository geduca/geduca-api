package br.com.geduca.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.geduca.api.model.enums.TipoReceitaEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Receita
 * 
 * @author gustavoclay
 * 
 */

@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "tb_receita")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_receita")
	private Long codigo;

	private String nome;

	private String descricao;

	@Column(name = "modo_preparo")
	private String modoPreparo;

	@Enumerated
	private TipoReceitaEnum tipoReceita;

	@ManyToMany
	private List<ProdutoReceita> produtos;

	@ManyToMany
	private List<RestricaoAliementar> restricaoAliementar;
}
