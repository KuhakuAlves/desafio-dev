package com.test.ByCodersTec.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.test.ByCodersTec.repository.IPersistenciaCNAB;

import junit.framework.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportarCNABTest {
	
	@MockBean
	private IPersistenciaCNAB persistBanco;
	
	@Autowired
	private IImportarCNAB service;
	
	private MultipartFile multipartFileToSend;

	private void setUpFile() {
		File file = new File("src/test/resources/testeImportar.txt");
		InputStream stream = null;
		try {
			stream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			multipartFileToSend = new MockMultipartFile("file", file.getName(), MediaType.TEXT_HTML_VALUE, stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testImportarArquivo() {
		setUpFile();
		
		doNothing().when(persistBanco).persistirDadosBanco(Mockito.any());
		boolean result = service.importar(multipartFileToSend);
		
		Assert.assertEquals(true, result);
	}
	

}
