package com.deepak.product.catalog.validator;

import com.deepak.product.catalog.entity.Brand;
import com.deepak.product.catalog.entity.Category;
import com.deepak.product.catalog.entity.Product;
import com.deepak.product.catalog.entity.ProductType;

import static org.apache.commons.lang3.StringUtils.*;


public class ProductValidator implements Validator<Product> {


    @Override
    public void validate(Product product) {

        validateProduct(product);
    }

    private void validateProduct(Product product) {

        assert product != null;
        assert isNotEmpty(product.getCode());
        assert isNotEmpty(product.getName());
        assert isNotEmpty(product.getDescription());
        validateProductType(product.getProductType());
        validateBrand(product.getBrand());

    }

    private void validateBrand(Brand brand) {
        assert brand != null;
        assert isNotEmpty(brand.getName());
    }

    private void validateProductType(ProductType productType) {

        assert productType != null;
        assert isNotEmpty(productType.getName());
        validateProductCategory(productType.getCategory());

    }

    private void validateProductCategory(Category category) {

        assert category != null;
        assert isNotEmpty(category.getName());
    }


}
