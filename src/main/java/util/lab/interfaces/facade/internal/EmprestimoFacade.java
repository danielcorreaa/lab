package util.lab.interfaces.facade.internal;

import java.util.List;

import util.lab.interfaces.facade.dto.EmprestimoDto;
import util.lab.interfaces.facade.dto.EmprestimoRequestDto;

public interface EmprestimoFacade {

	List<EmprestimoDto> buscarEmprestimo();
	
	EmprestimoDto emprestarLivro(EmprestimoRequestDto request);
	
	EmprestimoDto finalizarEmprestimo(Long id);
}
