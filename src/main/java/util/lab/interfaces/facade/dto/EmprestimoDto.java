package util.lab.interfaces.facade.dto;

import java.time.LocalDate;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmprestimoDto extends ResourceSupport{
	
	private PessoaDto pessoa;	
	private LivroDto livro;	
	private String situacao;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataSaida;	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataVolta;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPrevistaDevolucao;
	

}
