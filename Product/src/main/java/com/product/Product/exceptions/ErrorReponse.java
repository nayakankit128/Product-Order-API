package com.product.Product.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorReponse {

    private LocalDateTime timestamp;
    private String message;
    private int statusCode;


}
