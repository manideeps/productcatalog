package com.deepak.product.catalog.rest.impl;

import com.deepak.product.catalog.builder.ProductBuilder;
import com.deepak.product.catalog.dao.ProductDAO;
import com.deepak.product.catalog.entity.Product;
import com.deepak.product.catalog.rest.RestBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.*;

/**
 * Created by Deepak Mani on 15-07-2017.
 */

@Component
@Path("/products")
@Produces(APPLICATION_JSON)
@Api(value = "/products", description = "Operations on Products", produces = APPLICATION_JSON)
public class ProductRestservice implements RestBaseService<Product, String> {

    //Intermediate service layer not implemented,no transaction handling
    @Autowired
    ProductDAO productDAO;

    @GET
    @Path("/savedummy")
    public void createProductDummy() {

        Product product = new ProductBuilder("OP3", "Oneplus3")
                .description("OnePlus 3 ")
                .brand("Oneplus").type("Mobile")
                .category("Electronics")
                .tags(new HashSet<String>() {{

                    add("smartphone");
                    add("flagship");
                    add("2016");
                    add("china");

                }})
                .build();
        productDAO.save(product);
    }

    private URI getLocation(UriInfo uriInfo, Product product) {
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        return builder.path(product.getCode()).build();
    }

    @Override
    @POST
    @Consumes("application/json")
    @ApiOperation(value = "Create a New Product in the catalog", responseHeaders = {
            @ResponseHeader(name = "location", response = String.class,
                    description = "Based on location header can fetch the product")
    })
    public Response create(Product product, @Context UriInfo uriInfo) {
        productDAO.save(product);
        return created(getLocation(uriInfo, product)).build();
    }

    @Override
    @PUT
    @Consumes("application/json")
    @ApiOperation(value = "Create a New Product or Update the product in the catalog", responseHeaders = {
            @ResponseHeader(name = "location", response = String.class,
                    description = "Based on location header can fetch the product")
    })
    public Response saveOrUpdate(Product product, @Context UriInfo uriInfo) {
        productDAO.saveOrUpdate(product);
        return accepted().location(getLocation(uriInfo, product)).build();
    }

    @Override
    @DELETE
    @Path("{code}")
    @ApiOperation(value = "Delete the product by code in the catalog")
    public Response delete(@ApiParam("Code of the Product") @PathParam("code") String code, @Context UriInfo uriInfo) {
        productDAO.delete(code);
        return accepted().build();
    }

    @Override
    @GET
    @Path("{code}")
    @ApiOperation(value = "Get the product by code in the catalog")
    public Response getById(@ApiParam("Code of the Product") @PathParam("code") String code, @Context UriInfo uriInfo) {
        Product product = productDAO.getById(code);
        if (product != null)
            return accepted().entity(product).location(getLocation(uriInfo, product)).build();
        else
            return status(Status.NOT_FOUND).build();
    }

    @Override
    @GET
    @ApiOperation(value = "List all products in the catalog")
    public Response getAll(@ApiParam("Limit for the result") @QueryParam("limit") int limit) {

        Set<Product> products = productDAO.get(limit);
        return ok(products).build();
    }

    @GET
    @Path("/filter/productType/{type}")
    @ApiOperation(value = "Filter the product by its type")
    public Response filterByProductType(@ApiParam("Product Type of the product") @PathParam("type") String type) {
        Set<Product> products = productDAO.filterByProductType(type);
        return ok(products).build();
    }

    @GET
    @Path("/search")
    @ApiOperation(value = "Search the products using the criteria")
    public Response searchByCriteria(@ApiParam("Criteria name to search") @QueryParam("criteria") String criteria,
                                     @QueryParam("criteriaValue") String criteriaValue) {
        Set<Product> products = productDAO.searchByCriteria(criteria, criteriaValue);
        return ok(products).build();
    }

}
