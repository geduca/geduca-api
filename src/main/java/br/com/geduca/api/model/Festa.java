package br.com.geduca.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Festa
 * 
 * @ @author gustavoclay
 * 
 */
@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "tb_festa")
public class Festa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento")
	private Long codigo;

	private String nome;

	@ManyToOne
	private Aluno aluno;

	@Temporal(TemporalType.DATE)
	@Column()
	private LocalDate data;

	private Long duracao;
}
