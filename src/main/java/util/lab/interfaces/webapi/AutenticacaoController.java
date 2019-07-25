package util.lab.interfaces.webapi;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import util.lab.configs.security.TokenService;
import util.lab.interfaces.facade.dto.LoginRequestDto;
import util.lab.interfaces.facade.dto.TokenDto;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginRequestDto request){
		UsernamePasswordAuthenticationToken authentcationToken = request.converter();
		try {			
			Authentication authenticate = authenticationManager.authenticate(authentcationToken);
			
			String token = tokenService.gerarToken(authenticate);
			
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
