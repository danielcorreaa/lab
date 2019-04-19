package util.lab.service;

import java.util.List;

import util.lab.domain.model.Emprestimo;

public interface EmprestimoService {	
	
	public List<Emprestimo> buscarEmprestimos();
	
	public Emprestimo realizarEmprestimo(Long idPssoa, Long idLivro);

}
