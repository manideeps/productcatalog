package com.deepak.product.catalog.exception;

/**
 * Created by Deepak Mani on 15-07-2017.
 */
public abstract class ProductException extends RuntimeException {

    public ProductException(String message) {
        super(message);
    }
}
