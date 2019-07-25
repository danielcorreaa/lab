package util.lab.configs.exceptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import util.lab.domain.enums.SituacaoEnum;
import util.lab.domain.model.Livro;
import util.lab.domain.model.Pessoa;
import util.lab.domain.model.Usuario;
import util.lab.infrastructure.repositories.UsuarioRespository;
import util.lab.service.LivroService;
import util.lab.service.PessoaService;

@Component
public class CarregarDB implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private UsuarioRespository usuarioRepository;
	

	@Override
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		//inicializarDB();
		
		//iniciarUsuario();
		
		
	}


	@SuppressWarnings("unused")
	private void iniciarUsuario() {
		Usuario usuario = new Usuario("Daniel Aleixo Correa", "daniel", 
				"$2a$10$2Zk39FVEokosH54KOlZyCu1.BsflAdAJYJTon6ZaBCNHWW4JilhgO");
		usuarioRepository.save(usuario);
	}


	private void inicializarDB() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(new Pessoa("Zé Comia", "Floresta Número 234", SituacaoEnum.ATIVO.getDescricao()));
		pessoas.add(new Pessoa("Bart", "SpringField Número 10", SituacaoEnum.ATIVO.getDescricao()));
		pessoas.add(new Pessoa("Homer Simpson", "SpringField Número 10", SituacaoEnum.ATIVO.getDescricao()));
		pessoas.add(new Pessoa("Toguro", "Anime Número 200", SituacaoEnum.ATIVO.getDescricao()));
		pessoas.add(new Pessoa("Roberval Ladrão de Chocolate", "TV Colosso", SituacaoEnum.ATIVO.getDescricao()));
		
		pessoaService.salvarLista(pessoas);
		
		List<Livro> livros = new ArrayList<>();
		
		livros.add(new Livro("Senhor dos Aneis", "Abril", LocalDate.now(), SituacaoEnum.LIBERADO.getDescricao()));
		livros.add(new Livro("O Hobbit", "Abril", LocalDate.now(), SituacaoEnum.LIBERADO.getDescricao()));
		livros.add(new Livro("Senhor das moscas", "Abril", LocalDate.now(), SituacaoEnum.LIBERADO.getDescricao()));
		
		livros.forEach(livro ->
			livroService.salvar(livro)
		);
	}

}
