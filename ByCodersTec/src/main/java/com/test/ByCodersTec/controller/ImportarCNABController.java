package com.test.ByCodersTec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.ByCodersTec.service.IImportarCNAB;

import io.swagger.annotations.SwaggerDefinition;

@RestController
@RequestMapping(value = "/manipular-CNAB")
public class ImportarCNABController {
	
	@Autowired
	private IImportarCNAB importarCNABService;
	
	@PostMapping
	public String lerCNAB(@RequestParam("file") MultipartFile flie ) {
		
		importarCNABService.importar(flie);
		
		return "Enviado com sucesso";
	}

}
