package br.com.geduca.api.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.geduca.api.converters.TipoPessoaConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gustavoclay
 * 
 *         Classe Pessoa
 */
@Setter
@Getter
@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa", updatable = false)
	private Long codigo;

	@Column(name = "cpf_cnpj")
	private String cpfCpnj;

	@Convert(converter = TipoPessoaConverter.class)
	@Column(name = "tipo_pessoa")
	private TipoPessoa tipoPessoa;
	
	// TODO: CONTINUAR A IMPLEMENTAÇÃO DA CLASSE PESSOA

}
