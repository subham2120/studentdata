package com.School.Student.studentdata.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handlerResourceNotFound(ResourceNotFoundException ex){
        return ex.getMessage();
    }
}
