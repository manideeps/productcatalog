package com.deepak.product.catalog.entity;

import java.io.Serializable;

public final class Category implements Serializable {

    private String name;

    public Category() {
    }

    public Category(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
