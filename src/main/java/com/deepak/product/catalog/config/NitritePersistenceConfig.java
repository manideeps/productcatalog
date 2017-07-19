package com.deepak.product.catalog.config;


import com.deepak.product.catalog.entity.Product;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NitritePersistenceConfig {

    Logger logger = LoggerFactory.getLogger(NitritePersistenceConfig.class);

    @Bean
    Nitrite getNitrite() {
        return Nitrite.builder().openOrCreate();
    }

    @Bean
    ObjectRepository<Product> getProductRepository(Nitrite nitrite) {
        return nitrite.getRepository(Product.class);
    }

}
