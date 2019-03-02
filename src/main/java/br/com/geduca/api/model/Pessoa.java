package br.com.geduca.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Pessoa
 * 
 * @author gustavoclay
 * 
 */

@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long codigo;

	@NotNull
	private Boolean ativo;

	private String cpf;

	@NotNull
	private String nome;

	private String telefone;

	private String celular;

	@Embedded
	private Endereco endereco;

	@NotNull
	@Enumerated
	private SexoEnum sexo;

	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dt_nascimento")
	private LocalDate dataNascimento;

}
