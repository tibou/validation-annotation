package com.angularspring.validationannotation.handlers;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorInfo> handleException(MethodArgumentNotValidException ex){
        final FieldError field = ex.getBindingResult().getFieldError();
        if(field != null){
            return ResponseEntity.badRequest().body(new ErrorInfo(field.getField(), field.getDefaultMessage(), "API"));
        }

        return  null;
    }

    @Data
    public class ErrorInfo {

        private final String type;

        private final String origin;

        private final String message;

        ErrorInfo(String field, String message, String type){
            this.origin = field;
            this.message = message;
            this.type = type;
        }
    }
}
