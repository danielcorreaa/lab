package util.lab.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import util.lab.domain.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
