package br.com.geduca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.geduca.api.model.Usuario;

/**
 * @author gustavoclay
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}
