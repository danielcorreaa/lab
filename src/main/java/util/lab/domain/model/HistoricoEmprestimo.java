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
@Table(name="HistoricoEmprestimo")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Data
public class HistoricoEmprestimo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	@EqualsAndHashCode.Include
	@Column(name="id")
	private Long id;
	
	@NonNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_emprestimo")
	private Emprestimo emprestimo;
	
	@NonNull
	@Column(name="dataInclusao")
	private LocalDate dataInclusao;
	
}
