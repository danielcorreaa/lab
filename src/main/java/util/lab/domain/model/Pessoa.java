package util.lab.domain.model;

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
@Table(name="Pessoa")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Data
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	@Column(name="id")
	private Long id;
	@NonNull
	@Column(name="nome" , length=50)
	private String nome;
	@Column(name="endereco" , length=100)
	private String endereco;
	@Column(name="situacao" , length=1)
	private String situacao;
	
	@OneToMany(mappedBy="pessoa", fetch=FetchType.LAZY)
	private List<Emprestimo> emprestimos;

}
