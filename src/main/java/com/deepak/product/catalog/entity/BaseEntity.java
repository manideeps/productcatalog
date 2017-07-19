package com.deepak.product.catalog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public abstract class BaseEntity {

    @JsonIgnore
    private Date createdDate;
    @JsonIgnore
    private Date createdBy;
    @JsonIgnore
    private Date modifiedDate;
    @JsonIgnore
    private Date modifiedBy;

    public BaseEntity() {
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Date createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }


}
