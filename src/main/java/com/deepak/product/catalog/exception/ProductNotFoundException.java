package com.deepak.product.catalog.exception;

/**
 * Created by Deepak Mani on 15-07-2017.
 */
public final class ProductNotFoundException extends ProductException {

    public ProductNotFoundException() {
        super("Product Not Found Exception");
    }


}
