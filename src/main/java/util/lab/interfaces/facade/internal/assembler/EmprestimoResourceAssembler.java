package util.lab.interfaces.facade.internal.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import util.lab.domain.model.Emprestimo;
import util.lab.interfaces.facade.dto.EmprestimoDto;
import util.lab.interfaces.webapi.EmprestimoController;

@Component
public class EmprestimoResourceAssembler extends ResourceAssemblerSupport<Emprestimo, EmprestimoDto>{
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EmprestimoResourceAssembler() {
		super(EmprestimoController.class, EmprestimoDto.class);
	}

	@Override
	public EmprestimoDto toResource(Emprestimo entity) {
		EmprestimoDto resource = createResourceWithId(entity.getId(), entity);
		modelMapper.map(entity, resource);
		return resource;
	}
	
	@Override
	public List<EmprestimoDto> toResources(Iterable<? extends Emprestimo> entities) {		
		return super.toResources(entities);
	}

}
