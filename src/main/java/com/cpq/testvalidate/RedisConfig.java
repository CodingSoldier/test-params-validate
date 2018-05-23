//package com.cpq.testvalidate;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPoolConfig;
//
//@Configuration
//public class RedisConfig {
//
//    @Value("${spring.redis.database}")
//    private int database;
//
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    @Value("${spring.redis.pool.max-idle}")
//    private int maxidle;
//
//    @Value("${spring.redis.pool.min-idle}")
//    private int minidle;
//
//    @Value("${spring.redis.pool.max-active}")
//    private int maxActive;
//
//    @Value("${spring.redis.pool.max-wait}")
//    private long maxWait;
//
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxIdle(maxidle);
//        config.setMinIdle(minidle);
//        config.setMaxTotal(maxActive);
//        config.setMaxWaitMillis(maxWait);
//
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        factory.setDatabase(database);
//        factory.setHostName(host);
//        factory.setPort(port);
//        factory.setTimeout(timeout);
//        factory.setPoolConfig(config);
//        return factory;
//    }
//
//    @Bean
//    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate template = new RedisTemplate();
//        template.setConnectionFactory(factory);
//
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        template.setKeySerializer(stringRedisSerializer);
//        template.setHashKeySerializer(stringRedisSerializer);
//
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        return template;
//    }
//}