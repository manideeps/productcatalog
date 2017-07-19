package com.deepak.product.catalog.dao;

import com.deepak.product.catalog.entity.Product;

import java.util.Set;

public interface ProductDAO extends BaseDAO<Product, String> {

    Set<Product> filterByProductType(String type);

    Set<Product> searchByCriteria(String criteria, String criteriaValue);
}
