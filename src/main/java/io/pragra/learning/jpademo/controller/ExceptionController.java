package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.ErrorResponse;
import io.pragra.learning.jpademo.exception.AuthorNotFoundException;
import io.pragra.learning.jpademo.exception.BookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler({BookNotFoundException.class, AuthorNotFoundException.class})
    protected ResponseEntity<Object> bookNotFound(RuntimeException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ex.getMessage(), LocalDateTime.now(),"NOT_FOUND");
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
