package com.deepak.product.catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@Profile("db-redis")
public class RedisPersistanceConfiguration {


    @Bean
    JedisConnectionFactory jedisConnectionFactory() {

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setUsePool(true);
        return connectionFactory;
    }

    @Bean
    RedisTemplate redisTemplate(JedisConnectionFactory connectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
