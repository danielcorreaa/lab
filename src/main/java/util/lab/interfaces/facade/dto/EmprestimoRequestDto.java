package util.lab.interfaces.facade.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.Data;

@Data
public class EmprestimoRequestDto {
	
	private Long pessoa;	
	private Long livro;	
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPrevistaDevolucao;

}
