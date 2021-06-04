package br.org.serratec.backend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Anotação para um farejador de exceção
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	// Inserir a classe de erro do e-mail
	@ExceptionHandler(EmailException.class)
	public ResponseEntity<Object> handleEmailException(EmailException ex) {
		// Cria um objeto para receber a mensagem que foi lançada no erro
		EmailException emailException = new EmailException(ex.getMessage());
		//Retorna a mensagem no corpo do Json com o código 202 para tratamento de erro
		return ResponseEntity.unprocessableEntity().body(emailException);
	}
}
