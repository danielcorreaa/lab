package util.lab.interfaces.facade.internal;

import java.util.List;

import util.lab.interfaces.facade.dto.LivroDto;
import util.lab.interfaces.facade.dto.PessoaDto;

public interface LivroFacade {
	
	LivroDto salvar(PessoaDto request);
	
	void deletar(Long id);
	
	List<LivroDto> buscarTudo(int page, int size, String direction, String orderBy, String field, String value);
	
	LivroDto findById(Long id);

}
