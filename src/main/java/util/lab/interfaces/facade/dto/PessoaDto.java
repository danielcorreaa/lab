package util.lab.interfaces.facade.dto;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PessoaDto extends ResourceSupport{
	
	private String nome;	
	private String endereco;
	private String situacao;

}
