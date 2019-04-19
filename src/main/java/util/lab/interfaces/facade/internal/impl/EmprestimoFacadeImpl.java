package util.lab.interfaces.facade.internal.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.lab.interfaces.facade.dto.EmprestimoDto;
import util.lab.interfaces.facade.internal.EmprestimoFacade;
import util.lab.interfaces.facade.internal.assembler.EmprestimoResourceAssembler;
import util.lab.service.EmprestimoService;

@Component
public class EmprestimoFacadeImpl implements EmprestimoFacade {
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@Autowired
	private EmprestimoResourceAssembler assembler;

	@Override
	public List<EmprestimoDto> buscarEmprestimo() {
		List<EmprestimoDto> response = assembler.toResources(emprestimoService.buscarEmprestimos());
		return response;
	}

}
