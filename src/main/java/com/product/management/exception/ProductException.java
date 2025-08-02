package com.product.management.exception;

import static com.product.management.constant.ProductException.UNABLE_TO_FIND_PRODUCT;

public class ProductException extends RuntimeException{
    private String id;

    public ProductException(String id){
        super(UNABLE_TO_FIND_PRODUCT+id);
    }
}
