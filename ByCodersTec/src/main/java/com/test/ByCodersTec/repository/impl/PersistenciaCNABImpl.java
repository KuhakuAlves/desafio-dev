package com.test.ByCodersTec.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.ByCodersTec.model.CnabModel;
import com.test.ByCodersTec.repository.IPersistenciaCNAB;

@Repository
public class PersistenciaCNABImpl implements IPersistenciaCNAB {
	
	@Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	private String persistirSql = "INSERT INTO dadosbanco (tipotransacao, datatransacao, valor, cpf, cartao, hora, nmdono, nmloja) VALUES(:tipotransacao, :datatransacao, :valor, :cpf, :cartao, :hora, :nmdono, :nmloja)" ; 
	
	
	public void persistirDadosBanco(CnabModel model) {
		try {
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("tipotransacao", model.getTipoTransacao().getCodigo());
		params.addValue("datatransacao", model.getData() );
		params.addValue("valor", model.getValor());
		params.addValue("cpf", model.getCpf());
		params.addValue("cartao", model.getCartao());
		params.addValue("hora", model.getHora());
		params.addValue("nmdono", model.getDonoLoja());
		params.addValue("nmloja", model.getNomeLoja());
		
		namedJdbcTemplate.update(persistirSql, params);
		}catch(Exception e ) {
			throw new RuntimeException("Erro ao tentar gravar os dados na base, tp Transacao: " + model.getTipoTransacao().getDescricao(), e);
		}
		
	}

}
