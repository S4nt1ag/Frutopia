package com.grupoone.frutopia.exceptions;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	ProblemDetail handleNoSuchElementException(NoSuchElementException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());

		problemDetail.setStatus(HttpStatus.NOT_FOUND);
		problemDetail.setTitle("Recurso não encontrado");
		problemDetail.setType(URI.create("https://api.frutopia.com/errors/not-found"));
		return problemDetail;
	}

	// verifica se id não existe no database
	@ExceptionHandler(IdNotFoundException.class)
	ProblemDetail handleIdNotFoundException(IdNotFoundException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());

		problemDetail.setType(URI.create("https://api.frutopia.com/errors/id-not-found"));
		problemDetail.setTitle("O id inserido não existe no banco de dados");
		problemDetail.setStatus(HttpStatus.NOT_FOUND);
		problemDetail.setDetail("Id not found");
		return problemDetail;
	}
	
	// pega validação @NotNull, @Valid, @NotBlank
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, 
    		HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        ResponseEntity<Object> response = super.handleExceptionInternal(ex, body, headers, statusCode, request);

        if (response.getBody() instanceof ProblemDetail problemDetailBody) {
            problemDetailBody.setProperty("message", ex.getMessage());
            if (ex instanceof MethodArgumentNotValidException subEx) {
                BindingResult result = subEx.getBindingResult();                
                problemDetailBody.setTitle("Erro de validação na requisição");
                problemDetailBody.setDetail("Ocorreu um erro ao processar a requisição");
                problemDetailBody.setProperty("message", "Validation failed for object='" + 
                		result.getObjectName() + "'. " + "Error count: " + result.getErrorCount());
                
                // se precisar verificar detalhes do erro
//                problemDetailBody.setProperty("errors", result.getAllErrors());
            }
        }
        return response;
    }
}
