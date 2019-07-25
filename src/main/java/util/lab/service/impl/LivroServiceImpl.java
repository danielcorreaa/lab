package util.lab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import util.lab.configs.exceptions.BusinessException;
import util.lab.domain.model.Livro;
import util.lab.infrastructure.repositories.LivroRepository;
import util.lab.service.LivroService;

@Service
public  class LivroServiceImpl implements LivroService{
	
	@Autowired
	private LivroRepository livroRepository;

	@Override
	public Livro buscarPorId(final Long id) {
		return this.livroRepository.findById(id).orElseThrow(() -> 
				new BusinessException("Livro não encontrado com o id: "+id));
	}

	@Override
	public Livro buscarPorSituacao(final String situacao, final Long id) {
		return this.livroRepository.findBySituacaoAndId(situacao, id).orElseThrow(() -> 
			new BusinessException("Livro não encontrado com o status: " + situacao));
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	//@Qualifier("jpaTransactionManager")
	public Livro salvar(Livro livro) {		
		Livro save = null;
		try {			
			save = this.livroRepository.save(livro);			
		}catch (Exception e) {
			throw new BusinessException("Falha ao salvar Livro", e);
		}
		return save;
	}

	@Override
	public List<Livro> buscarLivros() {		
		return livroRepository.findAll();
	}

	
}
