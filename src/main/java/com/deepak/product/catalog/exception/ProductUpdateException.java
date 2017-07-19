package com.deepak.product.catalog.exception;

import com.deepak.product.catalog.entity.Product;

/**
 * Created by Deepak Mani on 15-07-2017.
 */
public final class ProductUpdateException extends ProductException {

    public ProductUpdateException(Product product) {
        super(String.format("Record not found for the product code %s ", product.getCode()));
    }

    public ProductUpdateException(ProductNotFoundException notFound) {
        super(notFound.getMessage());
    }
}
