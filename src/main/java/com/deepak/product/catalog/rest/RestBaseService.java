package com.deepak.product.catalog.rest;

import com.deepak.product.catalog.entity.BaseEntity;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Deepak Mani on 7/17/2017.
 */
public interface RestBaseService<T extends BaseEntity, ID> {

    Response create(T t, UriInfo uriInfo);

    Response saveOrUpdate(T t, UriInfo uriInfo);

    Response delete(ID id, UriInfo uriInfo);

    Response getById(ID id, UriInfo uriInfo);

    Response getAll(int limit);


}
