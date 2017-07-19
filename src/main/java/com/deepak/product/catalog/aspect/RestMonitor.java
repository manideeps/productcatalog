package com.deepak.product.catalog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Deepak Mani on 7/17/2017.
 */
@Aspect
@Component
public class RestMonitor {

    Logger logger = LoggerFactory.getLogger(RestMonitor.class);

    @Before("execution(* com.deepak.product.catalog.rest.RestBaseService.create(..))")
    public void onCreate(JoinPoint joinPoint) {
        logger.info("Rest. Creation of Entity ");
    }
}
