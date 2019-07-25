package util.lab.interfaces.webapi;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import util.lab.interfaces.facade.dto.PessoaDto;
import util.lab.interfaces.facade.internal.PessoaFacade;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaFacade pessoaFacade;
	
	public ResponseEntity<?> salvar(@RequestBody  PessoaDto request) throws URISyntaxException{
		PessoaDto response = this.pessoaFacade.salvar(request);
		return ResponseEntity.created(new URI(response.getSituacao())).build();
		
	}

}
