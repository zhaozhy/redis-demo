package com.example.redisdemo;

import com.example.redisdemo.entity.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

@SpringBootApplication
public class RedisDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RedisDemoApplication.class, args);
        Map<String, RedisTemplate> map = run.getBeansOfType(RedisTemplate.class);
       // System.out.println(map);

        RedisTemplate redisTemplate = run.getBean("redisTemplate",RedisTemplate.class);
        System.out.println(redisTemplate);
       redisTemplate.opsForValue().set("test1","fdsafd");
        System.out.println( redisTemplate.opsForValue().get("test1"));
        Order  order=new Order();
        order.setOrderId(1);
        order.setOrderName("订单名");
        redisTemplate.opsForValue().set("o1",order);
        System.out.println(redisTemplate.opsForValue().get("o1"));
        Order o1 =(Order) redisTemplate.opsForValue().get("o1");
        System.out.println(o1.getOrderName());
    }

}

