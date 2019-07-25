package util.lab.interfaces.facade.internal.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import util.lab.domain.model.Pessoa;
import util.lab.interfaces.facade.dto.PessoaDto;
import util.lab.interfaces.webapi.PessoaController;

@Component
public class PessoaResourceAssembler extends ResourceAssemblerSupport<Pessoa, PessoaDto> {

	@Autowired
	private ModelMapper modelMapper;

	public PessoaResourceAssembler() {
		super(PessoaController.class, PessoaDto.class);
	}

	@Override
	public PessoaDto toResource(Pessoa entity) {
		PessoaDto resource = createResourceWithId(entity.getId(), entity);
		modelMapper.map(entity, resource);
		return resource;
	}

	@Override
	public List<PessoaDto> toResources(Iterable<? extends Pessoa> entities) {
		return super.toResources(entities);
	}

}
