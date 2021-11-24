package com.spring.interview.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Controller advice to translate the server side exception to client-freindly
json structrues
*/
@ControllerAdvice
public class ExecptionTranslator {

	@ExceptionHandler(MyResourceNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorVM> processRessourceNotFound(MyResourceNotFoundException exception) {
		BodyBuilder builder;
		builder = ResponseEntity.status(HttpStatus.NOT_FOUND);
		return builder.body(new ErrorVM("NOT FOUND", exception.getMessage()));
	}

}
