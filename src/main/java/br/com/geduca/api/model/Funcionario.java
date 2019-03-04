package br.com.geduca.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@JoinColumn(unique = true)
	@OneToOne
	private Pessoa pessoa;

	private String formacao;

	private String area;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_matricula")
	private LocalDate dataMatricula;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_saida")
	private LocalDate dataSaida;

}
