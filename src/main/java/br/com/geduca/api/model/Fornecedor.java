package br.com.geduca.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe Fornecedor
 * 
 * @author gustavoclay
 * 
 */

@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "tb_fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fornecedor")
	private Long codigo;

	private Boolean ativo;

	private String nome;

	@Column(name = "cpf_cnpj")
	private String cpfCnpj;

	private Endereco endereco;

	private String telefone;

	private String email;

	private String reponsavel;

	@Column(name = "dt_matricula")
	private LocalDate dataMatricula;
}
