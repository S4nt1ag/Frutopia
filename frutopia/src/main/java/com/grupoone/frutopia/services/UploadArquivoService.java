package com.grupoone.frutopia.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.grupoone.frutopia.dto.UploadArquivoDTO;
import com.grupoone.frutopia.exceptions.UploadArquivoException;

@Service
public class UploadArquivoService {
	
	@Value("${pasta.upload.arquivos}")
	private String pastaUploadArquivos;
	
	private Path localArmazenamentoArq;
	
	public UploadArquivoDTO armazenaArquivo(MultipartFile file) {
		String clearFileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if(clearFileName.contains("..")) {
				throw new UploadArquivoException("Nome de arquivo inválido" + clearFileName);
			}
			
			this.localArmazenamentoArq = Paths.get(pastaUploadArquivos).toAbsolutePath().normalize();
			
			Path pastaDestino = this.localArmazenamentoArq.resolve(clearFileName);
			Files.copy(file.getInputStream(),pastaDestino, StandardCopyOption.REPLACE_EXISTING);
			
			return new UploadArquivoDTO(clearFileName, pastaUploadArquivos, file.getContentType(), file.getSize());
		}
		catch (IOException ex) {
			throw new UploadArquivoException("Ocorreu erro ao armazenar arquivo" + clearFileName, ex);
		}
	}
}
