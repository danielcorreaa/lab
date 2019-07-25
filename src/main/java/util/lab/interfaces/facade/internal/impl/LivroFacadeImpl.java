package util.lab.interfaces.facade.internal.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.lab.domain.model.Livro;
import util.lab.interfaces.facade.dto.LivroDto;
import util.lab.interfaces.facade.dto.PessoaDto;
import util.lab.interfaces.facade.internal.LivroFacade;
import util.lab.interfaces.facade.internal.assembler.LivroResourceAssembler;
import util.lab.service.LivroService;

@Component
public class LivroFacadeImpl implements LivroFacade {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private LivroResourceAssembler assembler;

	@Override
	public LivroDto salvar(PessoaDto request) {		
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LivroDto> buscarTudo(int page, int size, String direction, String orderBy, String field, String value) {
		List<Livro> buscarLivros = livroService.buscarLivros();
		return assembler.toResources(buscarLivros);
	}

	@Override
	public LivroDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
