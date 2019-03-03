package br.com.geduca.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe RestricaoAliementar
 * 
 * @author gustavoclay
 * 
 */
@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "tb_restricao_alimentar")
public class RestricaoAliementar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ficha_saude")
	private Long codigo;

	private String nome;

	private String descricao;

}
