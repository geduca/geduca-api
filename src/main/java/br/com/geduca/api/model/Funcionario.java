package br.com.geduca.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Funcionario
 * 
 * @author gustavoclay
 * 
 */

@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "tb_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Long codigo;

	@OneToOne
	private Pessoa pessoa;

	private String formacao;

	private String area;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dt_matricula")
	private LocalDate dataMatricula;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dt_saida")
	private LocalDate dataSaida;

}
