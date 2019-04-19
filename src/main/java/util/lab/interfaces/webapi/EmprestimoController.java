package util.lab.interfaces.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import util.lab.interfaces.facade.dto.EmprestimoDto;
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

}
