package com.example.redisdemo.config;

import com.example.redisdemo.serializer.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Configuration
public class RedisConfig {

    @Bean
     public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

         RedisTemplate<Object,Object> template=new RedisTemplate<>();

         FastJsonRedisSerializer fastJsonRedisSerializer=new FastJsonRedisSerializer(Object.class);
         template.setValueSerializer(fastJsonRedisSerializer);
         template.setHashKeySerializer(fastJsonRedisSerializer);
         template.setKeySerializer(new StringRedisSerializer());
         template.setHashKeySerializer(new StringRedisSerializer());
         template.setConnectionFactory(redisConnectionFactory);
         return  template;
     }
}
