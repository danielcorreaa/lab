package util.lab.interfaces.facade.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Data;

@Data
public class LoginRequestDto {
	
	private String login;
	private String senha;
	
	
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(login, senha);
	}

}
