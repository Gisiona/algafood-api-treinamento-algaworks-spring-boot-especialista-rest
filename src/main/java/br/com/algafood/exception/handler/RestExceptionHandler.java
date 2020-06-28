package br.com.algafood.exception.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.algafood.exception.RecursoNaoEncontradoException;
import br.com.algafood.exception.RecursoNaoPodeSerExcluidoConstraintSqlException;
import br.com.algafood.exception.ResponseException;

@ControllerAdvice
public class RestExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public ResponseEntity<?> handlerNotFoundException(HttpMediaTypeNotAcceptableException exc){
		ResponseException response = new ResponseException(HttpStatus.NOT_ACCEPTABLE.value(), "Formato do MediaType solicitado não permitido", LocalDateTime.now());		
		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerValidationFieldMethodArgumentNotValidException(MethodArgumentNotValidException exc){
		List<FieldError> fieldErrors = exc.getBindingResult().getFieldErrors();		
		List<ResponseException> response = new ArrayList<ResponseException>();				
		fieldErrors.forEach(e -> {	
			String msgErro = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ResponseException objErro = new ResponseException(HttpStatus.BAD_REQUEST.value(),e.getField(), LocalDateTime.now());
			response.add(objErro);
		});		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<?> handlerRecursoNaoEncontradoException(RecursoNaoEncontradoException exc){
		ResponseException response = new ResponseException(HttpStatus.NOT_FOUND.value(), exc.getMessage(), LocalDateTime.now());		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RecursoNaoPodeSerExcluidoConstraintSqlException.class)
	public ResponseEntity<?> handlerRecursoNaoPodeSerExcluidoConstraintSqlException(RecursoNaoPodeSerExcluidoConstraintSqlException exc){
		ResponseException response = new ResponseException(HttpStatus.NOT_ACCEPTABLE.value(), "O recurso não pode ser excluído, pois existem outras dependências.", LocalDateTime.now());		
		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
	}
	
}
