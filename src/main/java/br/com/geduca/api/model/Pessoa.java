package br.com.geduca.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private Long codigo;
	
	private String cpf;

	private String nome;

	private String telefone;

	private String celular;

	private String email;

	private String endereco;

	private String sexo;

	private String dataNascimento;

}
