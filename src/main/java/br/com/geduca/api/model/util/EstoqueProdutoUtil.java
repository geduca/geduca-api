package br.com.geduca.api.model.util;

import java.time.LocalDate;

import br.com.geduca.api.model.Produto;
import br.com.geduca.api.model.Unidade;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe EstoqueProduto
 * 
 * @author gustavoclay
 * 
 */

@Setter
@Getter
@EqualsAndHashCode
public class EstoqueProdutoUtil {

	private Produto produto;

	private Unidade unidade;

	private Long quantidade;

	private Long quantidadeMinima;

	private LocalDate dataRegistro;

}
