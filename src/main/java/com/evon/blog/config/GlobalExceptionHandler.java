package com.evon.blog.config;

import com.evon.blog.exception.DuplicateRecordException;
import com.evon.blog.exception.ErrorMessage;
import com.evon.blog.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<ErrorMessage> duplicateRecordException(DuplicateRecordException e){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.CONFLICT.value(), new Date(),e.getMessage(), e.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException e){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(),e.getMessage(), e.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
