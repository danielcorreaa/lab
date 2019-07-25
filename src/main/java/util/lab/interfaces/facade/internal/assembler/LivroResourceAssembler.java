package util.lab.interfaces.facade.internal.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import util.lab.domain.model.Livro;
import util.lab.interfaces.facade.dto.LivroDto;
import util.lab.interfaces.webapi.LivroController;

@Component
public class LivroResourceAssembler extends ResourceAssemblerSupport<Livro, LivroDto> {

	@Autowired
	private ModelMapper modelMapper;

	public LivroResourceAssembler() {
		super(LivroController.class, LivroDto.class);
	}

	@Override
	public LivroDto toResource(Livro entity) {
		LivroDto resource = createResourceWithId(entity.getId(), entity);
		modelMapper.map(entity, resource);
		return resource;
	}

	@Override
	public List<LivroDto> toResources(Iterable<? extends Livro> entities) {
		return super.toResources(entities);
	}

}
