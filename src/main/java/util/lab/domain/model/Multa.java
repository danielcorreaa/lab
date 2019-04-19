package util.lab.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="multa")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Data
public class Multa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_emprestimo")
	private Emprestimo emprestimo;
	
	@Column(name="valor")
	private BigDecimal valor;
	
	@NonNull
	@Column(name="data_multa")
	private LocalDate dataMulta;
	
	@Column(name="pago" , length=1)
	private String pago;

}
