package com.product.management.handler;

import com.product.management.exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProductException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productExceptionHandler(ProductException ex){
        return ex.getMessage();
    }

}
