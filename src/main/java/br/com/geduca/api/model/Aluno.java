package br.com.geduca.api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Aluno
 * 
 * @author gustavoclay
 * 
 */

@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "tb_aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Long codigo;

	@OneToOne
	private Pessoa pessoa;

	private String pai;

	private String mae;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dt_matricula")
	private LocalDate dataMatricula;

	@OneToOne
	private FichaSaude fichaSaude;

	@OneToMany
	private List<RestricaoAliementar> restricaoAlimentar;

}
