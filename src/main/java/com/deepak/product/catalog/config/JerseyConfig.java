package com.deepak.product.catalog.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by Deepak Mani on 7/17/2017.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("com.deepak.product.catalog.rest");

    }
}
