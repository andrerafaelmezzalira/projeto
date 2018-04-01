package br.com.projeto.domain;

public enum Status  {

	EM_ANALISE(1, "Em Análise"), //
	ANALISE_REALIZADA(2, "Análise Realizada"), //
	ANALISE_APROVADA(3, "Análise Aprovada"), //
	INICIADO(4, "Iniciado"), //
	PLANEJADO(5, "Planejado"), //
	EM_ANDAMENTO(6, "Em andamento"), //
	ENCERRADO(7, "Encerrado"), //
	CANCELADO(8, "Cancelado");
	
	private Integer id;
	private String descricao;
	
	private Status(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
