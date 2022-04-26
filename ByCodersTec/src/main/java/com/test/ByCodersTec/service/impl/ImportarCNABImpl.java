package com.test.ByCodersTec.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.ByCodersTec.model.CnabModel;
import com.test.ByCodersTec.repository.IPersistenciaCNAB;
import com.test.ByCodersTec.service.IImportarCNAB;
import com.test.ByCodersTec.util.CNABUtils;

@Service
public class ImportarCNABImpl implements IImportarCNAB {
	
	@Autowired
	private IPersistenciaCNAB persistCNAB;

	@Override
	public boolean importar(MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new RuntimeException("Arquivo inexistente.");
			}
			BufferedReader reader = new BufferedReader( new InputStreamReader( file.getInputStream() ) );

			String linha = "";
			while( ( linha = reader.readLine() ) != null )
	        {
				CnabModel model = CNABUtils.mapearParaObjeto(linha);
				persistCNAB.persistirDadosBanco(model);
	        }
			return true;
		}
		catch (IOException e) {
			throw new RuntimeException("Erro ao tentar ler o arquivo", e);
		}
		catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
