package com.product.Product.controller;

import com.product.Product.exceptions.ErrorReponse;
import com.product.Product.exceptions.ProductNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandle {


    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ErrorReponse> handleProductNotFoundException(ProductNotFound p){
        log.error("Exception occurred", p.getMessage());
        ErrorReponse errorReponse = new ErrorReponse(LocalDateTime.now(), p.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorReponse, HttpStatus.NOT_FOUND);
    }
}
