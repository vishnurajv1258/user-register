package com.dev.register.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.dev.register.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserRegistrationException.class)
	public ResponseEntity<ErrorResponse> handleUserExistsException(UserRegistrationException ex) {

		ErrorResponse errorResponse = ErrorResponse.builder().message(ex.getMessage()).error("Conflict")
				.status(HttpStatus.CONFLICT.value()).timestame(LocalDateTime.now()).build();

		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);

	}

	/*
	 * @ExceptionHandler(UserRegistrationException.class) public
	 * ResponseEntity<ErrorResponse>
	 * handleValidationException(MethodArgumentNotValidException ex) { Map<String,
	 * String> errors = new HashMap();
	 * 
	 * ex.getBindingResult().getFieldErrors().forEach(err ->
	 * errors.put(err.getField(), err.getDefaultMessage()));
	 * 
	 * ErrorResponse errorResponse = ErrorResponse.builder().error("Bad request")
	 * .status(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.value()
	 * ).build();
	 * 
	 * return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalExceptions(Exception ex, WebRequest req) {

		ErrorResponse err = ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(ex.getMessage()).error(HttpStatus.INTERNAL_SERVER_ERROR.name()).timestame(LocalDateTime.now())
				.build();

		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
