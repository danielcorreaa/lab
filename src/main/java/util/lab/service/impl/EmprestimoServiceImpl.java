package util.lab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.lab.domain.model.Emprestimo;
import util.lab.domain.shared.specifications.EmprestimoSpecification;
import util.lab.infrastructure.repositories.EmprestimoRepository;
import util.lab.service.EmprestimoService;
import util.lab.service.PessoaService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	private PessoaService pessoaService;
	
	private LivroServiceImpl livroService;

	@Override
	public List<Emprestimo> buscarEmprestimos() {
		EmprestimoSpecification specification = new EmprestimoSpecification();
		return emprestimoRepository.findAll(specification);
	}

	@Override
	public Emprestimo realizarEmprestimo(Long idPssoa, Long idLivro) {
		pessoaService.b
		return null;
	}

	
	
	

	

}
