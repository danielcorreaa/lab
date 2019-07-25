package util.lab.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import util.lab.domain.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> , JpaSpecificationExecutor<Pessoa> {
	
	Optional<Pessoa> findBySituacaoAndId(final String situacao, final Long id);
}
