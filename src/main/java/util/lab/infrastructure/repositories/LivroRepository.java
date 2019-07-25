package util.lab.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import util.lab.domain.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	Optional<Livro> findBySituacaoAndId(String situacao, final Long id);

}
