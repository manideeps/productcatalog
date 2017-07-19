package com.deepak.product.catalog.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dizitart.no2.IndexType;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

import java.io.Serializable;

@Indices({
        @Index(value = "productType.name", type = IndexType.NonUnique)
})
public class Product extends BaseEntity implements Serializable, Cloneable {

    @Id
    private String code;
    private String name;
    private String description;
    private Brand brand;
    private ProductType productType;

    // No Arg
    public Product() {
    }

    public Product(String code, String name, String description, Brand brand, ProductType productType) {
        super();
        this.code = code;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.productType = productType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;

        return new EqualsBuilder()
                .append(code, that.code)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(code)
                .toHashCode();
    }

    //Shallow Copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
