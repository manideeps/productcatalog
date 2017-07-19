package com.deepak.product.catalog.entity;

import java.io.Serializable;
import java.util.Set;

public class ProductType implements Serializable {

    private String name;
    private Category category;

    public ProductType() {
    }

    public ProductType(String name, Category category) {
        super();
        this.name = name;
        this.category = category;
    }

    private Set<String> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }


}
