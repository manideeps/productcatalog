package com.deepak.product.catalog.dao;

import com.deepak.product.catalog.entity.BaseEntity;

import java.util.Set;

public interface BaseDAO<T extends BaseEntity, ID> {

    /**
     * @param t
     * @return the affected records
     */
    int save(T t);

    int update(T t);

    int saveOrUpdate(T t);

    T getById(ID id);

    void delete(ID id);

    Set<T> get(int limit);


}
