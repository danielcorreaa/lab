package util.lab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import util.lab.configs.exceptions.BusinessException;
import util.lab.domain.enums.SituacaoEnum;
import util.lab.domain.model.Pessoa;
import util.lab.domain.shared.specifications.PessoaSpecification;
import util.lab.infrastructure.repositories.PessoaRepository;
import util.lab.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService{
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override	
	public Pessoa salvar(Pessoa pessoa) {
		
		Pessoa save = null;
		try {			
			save = this.pessoaRepository.save(pessoa);			
		}catch (Exception e) {
			throw new BusinessException("Falha ao salvar", e);
		}
		return save;
	}
	
	

	@Override
	public void excluir(Long id) {
		buscarPorId(id);
		this.excluir(id);
		
	}

	public Pessoa buscarPorId(Long id) {
		return this.pessoaRepository.findById(id).orElseThrow(() -> 
				 new BusinessException("Não encontrou Pessoa"));
	}

	@SuppressWarnings("static-access")
	@Override
	public Page<Pessoa> findAll(int page, int size, String direction, String orderBy, String field, String value) {
		Pageable request = null;
		Sort sort = null;
		Page<Pessoa> data = null;		
		if (direction.equals("ASC")) {
			sort = sort.by(Direction.ASC, orderBy);
		} else if (direction.equals("DESC")) {
			sort = sort.by(Direction.DESC, orderBy);
		}else {
			throw new BusinessException("Informe ASC ou DESC para direction ");
		}
		
		try {
			request = PageRequest.of(page, size, sort);
			Specification<Pessoa> spec = new PessoaSpecification(field, value);			
			data = this.pessoaRepository.findAll(spec, request);
		}catch (IllegalArgumentException e) {
			throw new BusinessException(e.getMessage());
		}catch (PropertyReferenceException ep) {
			throw new BusinessException(ep.getMessage());
		}	
		
		return data;
	}

	@Override
	public Pessoa buscarPorSituacao(final String situacao, final Long id) {
		return this.pessoaRepository.findBySituacaoAndId(situacao, id).orElseThrow(() -> 
			new BusinessException("Cliente não encontrado com o status: " + situacao));
	}



	@Override
	@Transactional( readOnly = false, propagation = Propagation.REQUIRED)
	//@Qualifier("jpaTransactionManager")
	public void salvarLista(List<Pessoa> pessoas) {
		
		for (Pessoa pessoa : pessoas) {
			
			if(pessoa.getSituacao().equals(SituacaoEnum.BLOQUEADO.getDescricao())) 
				throw new BusinessException("Situação inválida");
			try {
				pessoaRepository.save(pessoa);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
			
		
	}



}
