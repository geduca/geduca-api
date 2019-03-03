package br.com.geduca.api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import br.com.geduca.api.model.enums.PeriodoEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Turma
 * 
 * @author gustavoclay
 * 
 */

@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "tb_turma")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long codigo;

	private String nome;

	@OneToOne
	private Curso curso;

	@Enumerated
	private PeriodoEnum periodo;

	// TODO: CONTINUAR IMPLEMENTACAO
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Funcionario> funcionarios;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Aluno> alunos;

	@Column(name = "dt_inicio")
	private LocalDate dataInicio;

	@Column(name = "dt_fim")
	private LocalDate dataFim;

}
