package util.lab.configs.exceptions.details;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@JsonInclude(Include.NON_NULL)
@RequiredArgsConstructor
@Data
public class ExceptionDetailResponse {
	
	
	/**
	 * Data e hora em que a exceção ocorreu.
	 */
	@NonNull
	private LocalDateTime time;
	
	/**
	 * Mensagens informativas a serem exibidas para o usuário.
	 */
	@NonNull
	private String[] messages;

}
