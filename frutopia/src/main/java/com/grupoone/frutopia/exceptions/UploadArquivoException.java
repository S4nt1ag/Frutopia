package com.grupoone.frutopia.exceptions;

public class UploadArquivoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UploadArquivoException() {
		super();
	}

	public UploadArquivoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UploadArquivoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UploadArquivoException(String message) {
		super(message);
	}

	public UploadArquivoException(Throwable cause) {
		super(cause);
	}

}
