package util.lab.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import util.lab.domain.model.Multa;

public interface MultaRepository extends JpaRepository<Multa, Long>{	
	
	Multa findByPessoa(Long id);

}
