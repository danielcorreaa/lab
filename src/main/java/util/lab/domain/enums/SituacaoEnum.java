package util.lab.domain.enums;

public enum SituacaoEnum {

	// Pessoa
	ATIVO(1, "A"), BLOQUEADO(2, "B"),
	// Livro
	EMPRESTADO(3, "E"), LIBERADO(4, "L"),
	// Emprestimo
	FINALIZADO(5, "F"), INICIADO(8,"i"),
	// Multa
	PAGO(6, "P"), PENDENTEPAGAMENTO(7, "N");

	private int indice;
	private String descricao;

	SituacaoEnum(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getIndice() {
		return indice;
	}
	

}
