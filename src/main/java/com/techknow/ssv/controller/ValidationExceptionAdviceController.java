package com.techknow.ssv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author JyotiSingh
 *
 */
@ControllerAdvice
public class ValidationExceptionAdviceController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		return new ResponseEntity<>(processFieldErrors(fieldErrors), HttpStatus.BAD_REQUEST);
	}

	private Object processFieldErrors(List<FieldError> fieldErrors) {
		Map<String, Object> result = new HashMap<>();
		result.put("message", "There is a validation error");
		List<Map<String, String>> fieldErrorDetails = new ArrayList<>();
		
		for (FieldError fieldError : fieldErrors) {
			Map<String, String> field = new HashMap<>();
			field.put("field", fieldError.getField());
			field.put("field message", fieldError.getDefaultMessage());
			fieldErrorDetails.add(field);
		}
		result.put("fieldError", fieldErrorDetails);
		return result;
	}
}
