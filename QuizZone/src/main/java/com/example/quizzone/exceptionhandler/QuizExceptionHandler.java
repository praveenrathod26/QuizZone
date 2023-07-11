package com.example.quizzone.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuizExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<QuizErrorResponse> handleQuizException(QuizNotFoundException ex) {
        QuizErrorResponse errorResponse = new QuizErrorResponse();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
    	errorResponse.setMessage(ex.getMessage());
    	errorResponse.setTimeStamp(System.currentTimeMillis());
    	return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND);
    }
    

    @ExceptionHandler
    public ResponseEntity<QuizErrorResponse> handleQuizException(Exception ex) {
        QuizErrorResponse errorResponse = new QuizErrorResponse();
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
    	errorResponse.setMessage(ex.getMessage());
    	errorResponse.setTimeStamp(System.currentTimeMillis());
    	return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }
}