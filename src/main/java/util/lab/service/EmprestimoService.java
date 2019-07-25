package util.lab.service;

import java.util.List;

import util.lab.domain.model.Emprestimo;
import util.lab.interfaces.facade.dto.EmprestimoRequestDto;

public interface EmprestimoService {	
	
	public List<Emprestimo> buscarEmprestimos();
	
	public Emprestimo buscarPorId(final Long id);
	
	public Emprestimo realizarEmprestimo(EmprestimoRequestDto request);
	
	public Emprestimo finalizarEmprestimo(Long id);

}
