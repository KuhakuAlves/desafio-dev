package com.test.ByCodersTec.service;

import org.springframework.web.multipart.MultipartFile;

import com.test.ByCodersTec.model.CnabModel;

public interface IImportarCNAB {

	public boolean importar(MultipartFile file);
}
