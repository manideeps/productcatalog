package com.deepak.product.catalog.entity;

import java.io.Serializable;

public class Brand implements Serializable {

    private String name;

    public Brand() {
    }

    public Brand(String name) {
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
