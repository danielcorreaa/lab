package util.lab.interfaces.webapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import util.lab.interfaces.facade.dto.LivroDto;
import util.lab.interfaces.facade.dto.LivroRequestDto;
import util.lab.interfaces.facade.internal.LivroFacade;

@RestController
@RequestMapping("livro")
public class LivroController {
	
	@Autowired
	private LivroFacade livroFacade;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody LivroRequestDto request) throws URISyntaxException{
		LivroDto livroDto = livroFacade.salvar(request);
		return ResponseEntity.created(new URI(livroDto.getId().toString())).build();
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody LivroRequestDto request) throws URISyntaxException{
		LivroDto livroDto = livroFacade.salvar(request);
		return ResponseEntity.ok(livroDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable(value="id") Long id) throws URISyntaxException{
		livroFacade.deletar(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarLivros(){
		List<LivroDto> response = livroFacade.buscarTudo(0, 0, null, null, null, null);
		return ResponseEntity.ok(response);
	}

}
