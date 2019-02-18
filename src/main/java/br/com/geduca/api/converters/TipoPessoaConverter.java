package br.com.geduca.api.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.geduca.api.model.TipoPessoa;

/**
 * @author gustavoclay
 * 
 *         Classe Pessoa
 */
@Converter
public class TipoPessoaConverter implements AttributeConverter<TipoPessoa, String> {

	@Override
	public String convertToDatabaseColumn(TipoPessoa tipoPessoa) {
		return tipoPessoa.getCodigo();
	}

	@Override
	public TipoPessoa convertToEntityAttribute(String codigoTipoPessoa) {
		return TipoPessoa.getTipoPessoa(codigoTipoPessoa);
	}

}
