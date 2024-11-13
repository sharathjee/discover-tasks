package com.discover.deposit.discover_demo_1.exception;

import com.discover.deposit.discover_demo_1.model.CustomerAlreadyExistsException;
import com.discover.deposit.discover_demo_1.model.CustomerDoesNotExistException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.sound.midi.VoiceStatus;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<?> alreadyExistsException(CustomerAlreadyExistsException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerDoesNotExistException.class)
	public ResponseEntity<?> doestNotExistException(CustomerDoesNotExistException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorResponse onConstraintValidationException(jakarta.validation.ConstraintViolationException e) {
		ValidationErrorResponse error = new ValidationErrorResponse();
		for(ConstraintViolation c : e.getConstraintViolations() ) {
			error.getViolations().add(new Violation(c.getConstraintDescriptor().toString(), c.getMessage()));
		}
		return error;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ValidationErrorResponse error = new ValidationErrorResponse();
		for (ObjectError e : ex.getBindingResult().getAllErrors()) {
			error.getViolations().add(new Violation(e.getObjectName(),e.getDefaultMessage()));
		}
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
