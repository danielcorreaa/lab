package util.lab.domain.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Livro")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Data
public class Livro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	@Column(name="id")
	private Long id;
	
	@NonNull
	@Column(name="titulo" , length=50)
	private String titulo;
	
	@NonNull
	@Column(name="editora" , length=50)
	private String editora;
	
	@NonNull
	@Column(name="data_lancamento" , length=50)
	private LocalDate dataLancamento;
	
	@NonNull
	@Column(name="nome" , length=1)
	private String situacao;
	
	
	@OneToMany(mappedBy="livro", fetch=FetchType.LAZY)
	private List<Emprestimo> emprestimos;
}
