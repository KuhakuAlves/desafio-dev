package com.test.ByCodersTec.model;

import com.test.ByCodersTec.enums.TipoTransacao;

public class CnabModel {

private TipoTransacao tipoTransacao;
	
	private String data;
	
	private Double valor;
	
	private String cpf;
	
	private String cartao;
	
	private String hora;
	
	private String donoLoja;
	
	private String nomeLoja;

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDonoLoja() {
		return donoLoja;
	}

	public void setDonoLoja(String donoLoja) {
		this.donoLoja = donoLoja;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	
	
}
