package br.com.geduca.api.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

/**
 * @author gustavoclay
 * 
 *         Enum Tipo Pessoa Física ou Juridica
 */

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoPessoa {

	FISICA("F", "Física"), JURIDICA("J", "Jurídica");

	private String codigo;
	private String descricao;

	private TipoPessoa(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static TipoPessoa getTipoPessoa(String codigo) {
		for (TipoPessoa e : values()) {
			if (e.codigo.equals(codigo)) {
				return e;
			}
		}
		return null;
	}

	@JsonCreator
	public static TipoPessoa fromString(Map nome) {
		if (nome != null) {
			return TipoPessoa.getTipoPessoa((String) nome.get("codigo"));
		}
		return null;
	}
}
