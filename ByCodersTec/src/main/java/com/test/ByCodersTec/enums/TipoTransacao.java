package com.test.ByCodersTec.enums;

public enum TipoTransacao {
	
	DEBITO(1 , "Deposito", "Entrada"),
	BOLETO(2, "Boleto", "Saida" ),
	FINANCIAMENTO(3, "Financiamento", "Saida"),
	CREDITO(4, "Credito", "Entrada"),
	RECEBIMENTOEMPRESTIMO(5, " Recebimento Emprestimo", "Entrada"),
	VENDAS(6, "Vendas", "Entrada"),
	RECEBIMENTOTED(7, "Recebimento TED", "Entrada"),
	RECEBIMENTODOC(8, "Recebimento DOC", "Entrada"),
	ALUGUEL(9, "Aluguel", "Saida");
	
	private int codigo;
	
	private String descricao;
	
	private String tipoMov;
	
	private TipoTransacao(int codigo, String descricao, String tipoMov) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipoMov = tipoMov;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTipoMov() {
		return tipoMov;
	}

	public static TipoTransacao parseTipoTransacao(int codigo) {
		for (TipoTransacao tipo : TipoTransacao.values()) {
			if(tipo.getCodigo() == codigo)
				return tipo;
		}
		throw new RuntimeException("Não existe Tipo de Transação para o codigo: " + codigo);
	}
}

