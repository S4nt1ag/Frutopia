package com.grupoone.frutopia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grupoone.frutopia.dto.UploadArquivoDTO;
import com.grupoone.frutopia.services.UploadArquivoService;

@RestController
@RequestMapping("/upload")
public class UploadArquivoController {
	
	@Autowired
	UploadArquivoService uploadArquivoService;

	@PostMapping
	public ResponseEntity<UploadArquivoDTO> uploadArquivo(
			@RequestParam("nome_param") MultipartFile file){
		
		return new ResponseEntity<>(uploadArquivoService.armazenaArquivo(file), HttpStatus.CREATED);
	}
}