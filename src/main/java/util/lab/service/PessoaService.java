package util.lab.service;

import java.util.List;

import org.springframework.data.domain.Page;

import util.lab.domain.model.Pessoa;

public interface PessoaService {
	
	
	public Pessoa salvar(Pessoa pessoa);	
	public void salvarLista(List<Pessoa> pessoas);
	public Page<Pessoa> findAll(int page, int size, String direction, String orderBy, String field,String value);
	public void excluir(Long id);
	
	public Pessoa buscarPorId(Long id);
	
	public Pessoa buscarPorSituacao(final String situacao, final Long id);

}
