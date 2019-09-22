package util.lab.interfaces.webapi;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import util.lab.interfaces.facade.dto.PessoaDto;
import util.lab.interfaces.facade.dto.PessoaRequestDto;
import util.lab.interfaces.facade.internal.PessoaFacade;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaFacade pessoaFacade;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody PessoaRequestDto request) throws URISyntaxException{
		PessoaDto response = this.pessoaFacade.salvar(request);
		return ResponseEntity.created(new URI(response.getSituacao())).build();
		
	}
	
		
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody PessoaRequestDto request) throws URISyntaxException{
		PessoaDto response = pessoaFacade.salvar(request);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable(value="id") Long id) throws URISyntaxException{
		pessoaFacade.deletar(id);
		return ResponseEntity.ok().build();
	}

}
