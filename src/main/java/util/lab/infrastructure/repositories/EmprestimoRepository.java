package util.lab.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import util.lab.domain.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> ,JpaSpecificationExecutor<Emprestimo> {
	
	@Query(" select emp from Emprestimo emp "
		+ " join fetch emp.livro l "		
		+ " join fetch emp.pessoa p ")		
	public List<Emprestimo> buscarEmprestimos();

}
