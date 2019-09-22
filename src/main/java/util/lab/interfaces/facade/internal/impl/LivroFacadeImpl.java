package util.lab.interfaces.facade.internal.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.lab.domain.model.Livro;
import util.lab.interfaces.facade.dto.LivroDto;
import util.lab.interfaces.facade.dto.LivroRequestDto;
import util.lab.interfaces.facade.internal.LivroFacade;
import util.lab.interfaces.facade.internal.assembler.LivroResourceAssembler;
import util.lab.service.LivroService;

@Component
public class LivroFacadeImpl implements LivroFacade {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private LivroResourceAssembler assembler;
	
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public LivroDto salvar(LivroRequestDto request) {	
		Livro livro = modelMapper.map(LivroRequestDto.class, Livro.class);
		return assembler.toResource(livroService.salvar(livro));
	}

	@Override
	public void deletar(Long id) {
		livroService.deletar(id);
	}

	@Override
	public List<LivroDto> buscarTudo(int page, int size, String direction, String orderBy, String field, String value) {
		List<Livro> buscarLivros = livroService.buscarLivros();
		return assembler.toResources(buscarLivros);
	}

	@Override
	public LivroDto findById(Long id) {		
		return assembler.toResource(livroService.buscarPorId(id));
	}

	

}
