package util.lab.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Emprestimo")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Data
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	@EqualsAndHashCode.Include
	@Column(name="id")
	private Long id;
	
	@NonNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	@NonNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_livro")
	private Livro livro;	
	
	@NonNull
	@Column(name="situacao" , length=1)
	private String situacao;
	
	@NonNull
	@Column(name="saida")
	private LocalDate dataSaida;	
	
	@Column(name="volta")
	private LocalDate dataVolta;
	
	@NonNull
	@Column(name="data_prev_devolucao")
	private LocalDate dataPrevistaDevolucao;
	

	

}
