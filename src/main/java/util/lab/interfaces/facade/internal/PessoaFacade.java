package util.lab.interfaces.facade.internal;

import java.util.List;

import util.lab.interfaces.facade.dto.PessoaDto;
import util.lab.interfaces.facade.dto.PessoaRequestDto;

public interface PessoaFacade {
	
	PessoaDto salvar(PessoaRequestDto request);
	
	void deletar(Long id);
	
	List<PessoaDto> buscarTudo(int page, int size, String direction, String orderBy, String field, String value);
	
	PessoaDto findById(Long id);

}
