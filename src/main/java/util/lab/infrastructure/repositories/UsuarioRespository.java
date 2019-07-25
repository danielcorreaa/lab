package util.lab.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import util.lab.domain.model.Usuario;

public interface UsuarioRespository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByLogin(String login);
	
}
