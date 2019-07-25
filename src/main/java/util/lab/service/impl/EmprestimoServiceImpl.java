package util.lab.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import util.lab.configs.exceptions.BusinessException;
import util.lab.domain.enums.SituacaoEnum;
import util.lab.domain.model.Emprestimo;
import util.lab.domain.model.HistoricoEmprestimo;
import util.lab.domain.model.Livro;
import util.lab.domain.model.Multa;
import util.lab.domain.model.Pessoa;
import util.lab.domain.shared.specifications.EmprestimoSpecification;
import util.lab.infrastructure.repositories.EmprestimoRepository;
import util.lab.infrastructure.repositories.HistoricoEmprestimoRepository;
import util.lab.infrastructure.repositories.MultaRepository;
import util.lab.interfaces.facade.dto.EmprestimoRequestDto;
import util.lab.service.EmprestimoService;
import util.lab.service.PessoaService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private LivroServiceImpl livroService;
	
	@Autowired
	private MultaRepository multaRepository;
	
	@Autowired
	private HistoricoEmprestimoRepository historicoEmprestimoRepository;

	@Override
	public List<Emprestimo> buscarEmprestimos() {
		EmprestimoSpecification specification = new EmprestimoSpecification();
		return emprestimoRepository.findAll(specification);
	}

	@Override
	@Transactional
	public Emprestimo realizarEmprestimo(final EmprestimoRequestDto request) {	
		
		validarDadosEntrada(request);		
		validarSeTemMultaEmAtraso(request);
		
		Livro livro = livroService.buscarPorSituacao(SituacaoEnum.LIBERADO.getDescricao(), request.getLivro());
		
		Pessoa pessoa = pessoaService.buscarPorSituacao(SituacaoEnum.ATIVO.getDescricao(), request.getPessoa());
		
		Emprestimo emprestimo = new Emprestimo
				(pessoa, livro, SituacaoEnum.INICIADO.getDescricao(), 
						LocalDate.now(), request.getDataPrevistaDevolucao());
		
		Emprestimo response = salvarEm(emprestimo);
		
		livro.emprestar();
		livroService.salvar(livro);
		
		pessoa.bloquear();
		pessoaService.salvar(pessoa);
		
		this.historicoEmprestimoRepository.save(new HistoricoEmprestimo(emprestimo, LocalDate.now()));
		
		return response;
	}
	
	@Override
	@Transactional
	public Emprestimo finalizarEmprestimo(Long id) {
		Emprestimo emprestimo = buscarPorId(id);
		
		emprestimo.setDataVolta(LocalDate.now());
		emprestimo.setSituacao(SituacaoEnum.FINALIZADO.getDescricao());
		Emprestimo response = salvarEm(emprestimo);			
		Pessoa pessoa = emprestimo.getPessoa();
		pessoaService.salvar(pessoa);
		Livro livro = emprestimo.getLivro();
		livroService.salvar(livro);
		
		this.historicoEmprestimoRepository.save(new HistoricoEmprestimo(emprestimo, LocalDate.now()));
		
		if(LocalDate.now().isAfter(emprestimo.getDataPrevistaDevolucao())) {			
			multaRepository.save(new Multa(id, pessoa.getId() , new BigDecimal("0"), LocalDate.now(), 
						SituacaoEnum.PAGO.getDescricao()));			
		}
		
		return response;
	}
	

	private void validarSeTemMultaEmAtraso(final EmprestimoRequestDto request) {
		Multa multa = multaRepository.findByPessoa(request.getPessoa());
		if(multa != null && multa.getPago().equals(SituacaoEnum.PENDENTEPAGAMENTO)) {
			throw new BusinessException("Emprestimo não pode ser realizado enquanto a multa não for paga");
		}
	}

	private void validarDadosEntrada(EmprestimoRequestDto request) {
		if(request.getDataPrevistaDevolucao().equals(LocalDate.now())
				&& request.getDataPrevistaDevolucao().isBefore(LocalDate.now())) {
			throw new BusinessException("Data de previsão de devolução não pode "
					+ "ser anterior ou igual ao dia atual");
		}
	}

	private Emprestimo salvarEm(Emprestimo emprestimo) {
		Emprestimo save = null;
		try {			
			save = emprestimoRepository.save(emprestimo);
		}catch (Exception e) {
			throw new BusinessException("Falha ao salvar", e);
		}
		return save;		
	}


	@Override
	public Emprestimo buscarPorId(final Long id) {
		return this.emprestimoRepository.findById(id).orElseThrow(() -> 
				new BusinessException("Emprestimo não encontrado com o id: "+id));
	}

	
	
	

	

}
