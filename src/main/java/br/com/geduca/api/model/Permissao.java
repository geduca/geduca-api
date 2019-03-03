package br.com.geduca.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Permissao
 * 
 * @author gustavoclay
 *
 */
@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "tb_permissao")
public class Permissao {

	@Id
	@Column(name = "id_permissao")
	private Long codigo;

	private String descricao;
}
