package util.lab.service;

import java.util.List;

import util.lab.domain.model.Livro;

public interface LivroService {
	
	public Livro buscarPorId(Long id);
	public Livro buscarPorSituacao(final String situacao, final Long id);
	public Livro salvar(Livro livro);
	
	public List<Livro> buscarLivros();

}
