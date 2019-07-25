package util.lab.interfaces.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import util.lab.interfaces.facade.dto.LivroDto;
import util.lab.interfaces.facade.internal.LivroFacade;

@RestController
@RequestMapping("livro")
public class LivroController {
	
	@Autowired
	private LivroFacade livroFacade;
	
	
	@GetMapping("/list")
	public ResponseEntity<?> listarLivros(){
		List<LivroDto> response = livroFacade.buscarTudo(0, 0, null, null, null, null);
		return ResponseEntity.ok(response);
	}

}
