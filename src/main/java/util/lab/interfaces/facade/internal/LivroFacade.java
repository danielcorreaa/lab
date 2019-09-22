package util.lab.interfaces.facade.internal;

import java.util.List;

import util.lab.interfaces.facade.dto.LivroDto;
import util.lab.interfaces.facade.dto.LivroRequestDto;

public interface LivroFacade {	
	
	
	public void deletar(Long id);
	
	public List<LivroDto> buscarTudo(int page, int size, String direction, String orderBy, String field, String value);
	
	public LivroDto findById(Long id);
	
	public LivroDto salvar(LivroRequestDto request);

}
