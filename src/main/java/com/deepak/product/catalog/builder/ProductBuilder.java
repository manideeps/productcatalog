package com.deepak.product.catalog.builder;

import com.deepak.product.catalog.entity.Brand;
import com.deepak.product.catalog.entity.Category;
import com.deepak.product.catalog.entity.Product;
import com.deepak.product.catalog.entity.ProductType;
import com.deepak.product.catalog.validator.ProductValidator;

import java.util.Set;


public class ProductBuilder {

    private ProductValidator validator = new ProductValidator();
    private String code;
    private String brandName;
    private String categoryName;
    private String productTypeName;
    private String productName;
    private String productDescription;
    private Set<String> tags;

    public ProductBuilder(String code, String productName) {
        this.code = code;
        this.productName = productName;
    }

    public ProductBuilder brand(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public ProductBuilder type(String type) {
        this.productTypeName = type;
        return this;
    }

    public ProductBuilder category(String category) {
        this.categoryName = category;
        return this;
    }

    public ProductBuilder tags(Set<String> tags) {
        this.tags = tags;
        return this;
    }

    public ProductBuilder description(String description) {
        this.productDescription = description;
        return this;
    }

    public Product build() {

        Brand brand = new Brand(brandName);
        Category category = new Category(categoryName);
        ProductType productType = new ProductType(productTypeName, category);
        productType.setTags(tags);
        Product product = new Product(code, productName, productDescription, brand, productType);
        validator.validate(product);
        return product;

    }

}
