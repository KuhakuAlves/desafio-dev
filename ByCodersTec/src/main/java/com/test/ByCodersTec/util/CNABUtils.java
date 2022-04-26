package com.test.ByCodersTec.util;

import com.test.ByCodersTec.enums.TipoTransacao;
import com.test.ByCodersTec.model.CnabModel;

public class CNABUtils {

	public static CnabModel mapearParaObjeto(String linha) {
		try {
			CnabModel model = new CnabModel();
			model.setTipoTransacao(TipoTransacao.parseTipoTransacao(Integer.parseInt(linha.substring(0, 1))));
			model.setData(linha.substring(1, 9));
			model.setValor((Double.valueOf(linha.substring(9, 19)) / 100));
			model.setCpf(linha.substring(19, 30));
			model.setCartao(linha.substring(30, 42));
			model.setHora(linha.substring(42, 48));
			model.setDonoLoja(linha.substring(48, 62));
			model.setNomeLoja(linha.substring(62, 80));

			return model;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao transformar a informação em objeto linha: " + linha, e);
		}
		
	}
	
	
}
