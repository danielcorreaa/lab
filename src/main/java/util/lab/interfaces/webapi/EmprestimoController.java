package util.lab.interfaces.webapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import util.lab.interfaces.facade.dto.EmprestimoDto;
import util.lab.interfaces.facade.dto.EmprestimoRequestDto;
import util.lab.interfaces.facade.internal.EmprestimoFacade;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {
	
	@Autowired
	private EmprestimoFacade emprestimoFacade;
	
	@GetMapping("/listar")
	public ResponseEntity<?> buscarInformacoesSerasa(){		
		List<EmprestimoDto> response = emprestimoFacade.buscarEmprestimo();
		return ResponseEntity.ok(response);		
	}
	
	@PostMapping("realizarEmprestimo")
	public ResponseEntity<?> emprestarLivro(@RequestBody EmprestimoRequestDto request) throws URISyntaxException{
		EmprestimoDto response = emprestimoFacade.emprestarLivro(request);
		return ResponseEntity.created(new URI(response.getSituacao())).build();
	}
	
	@PostMapping("devolucaoEmprestimo/{id}")
	public ResponseEntity<?> devolverLivro(@PathVariable(value="id") Long id) throws URISyntaxException{
		EmprestimoDto response = emprestimoFacade.finalizarEmprestimo(id);
		return ResponseEntity.created(new URI(response.getSituacao())).build();
	}

}
