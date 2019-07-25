package util.lab.interfaces.facade.dto;

import lombok.Data;

@Data
public class TokenDto {	
	
	private String token;
	private String tipoAutenticacao;

	public TokenDto(String token, String tipoAutenticacao) {
		this.token = token;
		this.tipoAutenticacao = tipoAutenticacao;
	}

}


