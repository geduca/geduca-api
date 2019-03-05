package br.com.geduca.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe RegistroNutricial
 * 
 * @author gustavoclay
 * 
 */
@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "tb_registro_nutricional")
public class RegistroNutricional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro_nutricional")
	private Long codigo;

	@ManyToOne
	private Aluno aluno;

	private Float peso;

	private Float altura;

	private Float imc;

	@Column(name = "dt_registro")
	private LocalDate dataRegistro;

}
