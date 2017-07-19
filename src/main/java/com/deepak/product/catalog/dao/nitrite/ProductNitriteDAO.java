package com.deepak.product.catalog.dao.nitrite;

import com.deepak.product.catalog.dao.ProductDAO;
import com.deepak.product.catalog.entity.Product;
import org.dizitart.no2.objects.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.dizitart.no2.FindOptions.limit;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;
import static org.dizitart.no2.objects.filters.ObjectFilters.regex;


@Component
public class ProductNitriteDAO implements ProductDAO {


    @Autowired
    ObjectRepository<Product> repository;

    @Override
    public int save(Product product) {
        return repository.insert(product).getAffectedCount();
    }

    @Override
    public int update(Product product) {
        return repository.update(product).getAffectedCount();
    }

    @Override
    public int saveOrUpdate(Product product) {
        return repository.update(product, true).getAffectedCount();
    }

    @Override
    public Product getById(String code) {
        return repository.find(eq("code", code), limit(0, 1)).firstOrDefault();
    }

    @Override
    public void delete(String code) {
        repository.remove(eq("code", code));
    }

    @Override
    public Set<Product> get(int limit) {
        if (limit > 0)
            return iteratorToEntitySet(repository.find(limit(0, limit)).iterator());
        else
            return iteratorToEntitySet(repository.find().iterator());

    }

    private Set<Product> iteratorToEntitySet(Iterator<Product> productIterator) {
        Set<Product> products = new HashSet<>();
        productIterator.forEachRemaining(products::add);
        return products;
    }


    @Override
    public Set<Product> filterByProductType(String type) {

        return iteratorToEntitySet(
                repository.find(eq("productType.name", type)).iterator()
        );

    }

    @Override
    public Set<Product> searchByCriteria(String criteria, String criteriaValue) {
        return iteratorToEntitySet(
                repository.find(regex(criteria, criteriaValue)).iterator()
        );

    }
}
