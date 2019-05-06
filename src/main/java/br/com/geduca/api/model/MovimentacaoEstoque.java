package br.com.geduca.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.geduca.api.model.enums.TipoMovimentacaoEstoqueEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe MovimentacaoEstoque
 * 
 * @author gustavoclay
 * 
 */

@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "tb_movimentacao_estoque")
public class MovimentacaoEstoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movimentacao_estoque")
	private Long codigo;

	@OneToOne
	private ProdutoEstoque produtoEstoque;

	@Enumerated
	private TipoMovimentacaoEstoqueEnum tipo;

	private LocalDate dataRegistro;

}
