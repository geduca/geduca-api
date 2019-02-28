package br.com.geduca.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Usuario
 * 
 * @author gustavoclay
 *
 */

@Setter
@Getter
@EqualsAndHashCode
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String username;

	private String email;

	private String password;

}
