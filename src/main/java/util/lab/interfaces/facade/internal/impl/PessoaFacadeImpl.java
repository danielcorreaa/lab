package util.lab.interfaces.facade.internal.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import util.lab.domain.model.Pessoa;
import util.lab.interfaces.facade.dto.PessoaDto;
import util.lab.interfaces.facade.dto.PessoaRequestDto;
import util.lab.interfaces.facade.internal.PessoaFacade;
import util.lab.interfaces.facade.internal.assembler.PessoaResourceAssembler;
import util.lab.service.PessoaService;

@Component
public class PessoaFacadeImpl implements PessoaFacade{
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaResourceAssembler assembler;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PessoaDto salvar(PessoaRequestDto request) {
		Pessoa pessoa = modelMapper.map(request, Pessoa.class);		
		return assembler.toResource(this.pessoaService.salvar(pessoa) );
	}

	@Override
	public void deletar(Long id) {
		pessoaService.excluir(id);
	}

	@Override
	public List<PessoaDto> buscarTudo(int page, int size, String direction, String orderBy, String field, String value) {
		Page<Pessoa> list = pessoaService.findAll(page, size, direction, orderBy, field, value);
		return assembler.toResources(list);
	}

	@Override
	public PessoaDto findById(Long id) {		
		return assembler.toResource(this.pessoaService.buscarPorId(id));
	}

}
