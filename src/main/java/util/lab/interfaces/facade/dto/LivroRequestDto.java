package util.lab.interfaces.facade.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LivroRequestDto {

	private String titulo;
	private String editora;	
	private LocalDate dataLancamento;
	private String situacao;
	
}
