package util.lab.configs.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import util.lab.domain.model.Usuario;

@Service
public class TokenService {
	
	@Value("${biblioteca.jwt.expiration}")
	private String expiration;
	
	@Value("${biblioteca.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authenticate) {
		Usuario logado = (Usuario) authenticate.getPrincipal();
		Date hoje = new Date();
		
		Date dataExpiration = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("Api Biblioteca")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean tokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {		
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return  Long.parseLong(body.getSubject());
	}

}
