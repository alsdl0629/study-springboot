package com.example.socketcommunication.global.error;

import com.example.socketcommunication.global.error.exception.BusinessException;
import com.example.socketcommunication.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(BusinessException e) {
        final ErrorCode errorCode = e.getErrorCode();

        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(), errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                new ErrorResponse(400, e.getBindingResult().getAllErrors().get(0).getDefaultMessage()),
                HttpStatus.BAD_REQUEST);
    }

}
