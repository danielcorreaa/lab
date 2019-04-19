package util.lab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.lab.configs.BusinessException;
import util.lab.domain.model.Livro;
import util.lab.infrastructure.repositories.LivroRepository;
import util.lab.service.LivroService;

@Service
public class LivroServiceImpl implements LivroService{
	
	@Autowired
	private LivroRepository livroRepository;

	@Override
	public Livro buscarPorId(Long id) {
		return this.livroRepository.findById(id).orElseThrow(() -> 
				new BusinessException("Não encontrou Liro"));
	}

	
}
