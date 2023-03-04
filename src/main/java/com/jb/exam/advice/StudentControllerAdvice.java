package com.jb.exam.advice;

import com.jb.exam.exceptions.SchoolSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentControllerAdvice {
    @ExceptionHandler(value = {SchoolSystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handle(Exception e) {
        return new ErrorDetails("Student system error: ", e.getMessage());
    }
}
