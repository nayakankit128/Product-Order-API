package com.product.Product.exceptions;

public class ProductNotFound extends RuntimeException{
    public  ProductNotFound(String message){
        super(message);
    }
}
