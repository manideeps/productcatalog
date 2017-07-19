package com.deepak.product.catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class Application implements CommandLineRunner {

    @Override
    public void run(String... args) {
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    Swagger for Rest API not ready
     */
    //@Bean
//    public Docket petApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .pathMapping("/");
//
//    }


}
