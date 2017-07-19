package com.deepak.product.catalog.aspect;

import com.deepak.product.catalog.entity.BaseEntity;
import com.deepak.product.catalog.exception.ProductNotFoundException;
import com.deepak.product.catalog.exception.ProductUpdateException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Deepak Mani on 7/17/2017.
 * Monitor to handle the validation,logs ..
 */
@Aspect
@Component
public class PersistenceMonitor {

    Logger logger = LoggerFactory.getLogger(PersistenceMonitor.class);

    @Before("execution(* com.deepak.product.catalog.dao.BaseDAO.save(..)) && args(baseEntity)")
    public void logSave(JoinPoint joinPoint, BaseEntity baseEntity) {
        logger.info("{} Entity to be persisted ", baseEntity.getClass().getTypeName());
    }

    @AfterReturning(value = "execution(* com.deepak.product.catalog.dao.BaseDAO.update(..)) && args(baseEntity)", returning = "affectedCount")
    public void validateUpdate(JoinPoint joinPoint, BaseEntity baseEntity, int affectedCount) {

        if (affectedCount == 0) {
            logger.info("{} Entity Object not found in Persistance", baseEntity.getClass().getTypeName());
            throw new ProductUpdateException(new ProductNotFoundException());
        }

    }
}
