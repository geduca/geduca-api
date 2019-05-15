package br.com.geduca.api.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.geduca.api.model.RegistroNutricional;
import br.com.geduca.api.repository.RegistroNutricionalRepository;

/**
 * 
 * @author gustavoclay
 * 
 */
@Service
public class RegistroNutricionalService {

	@Autowired
	private RegistroNutricionalRepository registroNutricionalRepository;

	public RegistroNutricional salvar(RegistroNutricional registroNutricional) {
		registroNutricional.setDataRegistro(LocalDate.now());
		return registroNutricionalRepository.save(registroNutricional);
	}

	public RegistroNutricional atualizar(Long codigo, RegistroNutricional registroNutricional) {
		RegistroNutricional registroNutricionalSalvo = buscarRegistroNutricionalPeloCodigo(codigo);
		BeanUtils.copyProperties(registroNutricional, registroNutricionalSalvo, "codigo");
		return registroNutricionalRepository.save(registroNutricionalSalvo);
	}

	public RegistroNutricional buscarRegistroNutricionalPeloCodigo(Long codigo) {
		RegistroNutricional registroNutricionalSalvo = registroNutricionalRepository.getOne(codigo);
		if (registroNutricionalSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return registroNutricionalSalvo;
	}

	public List<RegistroNutricional> findAllList() {
		return registroNutricionalRepository.findAll();
	}

	public Optional<RegistroNutricional> findById(Long codigo) {
		return registroNutricionalRepository.findById(codigo);
	}

	public void deleteById(Long codigo) {
		registroNutricionalRepository.deleteById(codigo);
	}
	
//	TODO: IMPLEMENTAR
//	public float calculaImc() {
//		
//	}

}
