package util.lab.interfaces.facade.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PessoaRequestDto {
	
	private String nome;	
	private String endereco;
	private String situacao;

}
