package util.lab.service;

import java.util.List;

import org.springframework.data.domain.Page;

import util.lab.domain.model.Pessoa;

public interface PessoaService {
	
	
	Pessoa salvar(Pessoa pessoa);	
	void salvarLista(List<Pessoa> pessoas);
	Page<Pessoa> findAll(int page, int size, String direction, String orderBy, String field,String value);
	void excluir(Long id);
	
	public Pessoa buscarPorId(Long id);
	
	public Pessoa buscarPorSituacao(final String situacao, final Long id);

}
