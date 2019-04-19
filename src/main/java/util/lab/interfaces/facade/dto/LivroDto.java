package util.lab.interfaces.facade.dto;

import java.time.LocalDate;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LivroDto extends ResourceSupport{
	
	private String titulo;
	private String editora;	
	private LocalDate dataLancamento;
	private String situacao;
	
	

}
