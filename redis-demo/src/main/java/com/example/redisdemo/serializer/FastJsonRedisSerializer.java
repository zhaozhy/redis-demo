package com.example.redisdemo.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.Serializable;
import java.nio.charset.Charset;

public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

     public static final Charset DEFAULT_CHARSET=Charset.forName("UTF-8");

     private  Class<T> aClass;


     public  FastJsonRedisSerializer(Class<T> aClass)
     {
         super();
         this.aClass=aClass;

     }

    @Override
    public byte[] serialize(T o) throws SerializationException {
       if(null==o)
        return new byte[0];

       return JSON.toJSONString(o, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
         if(null ==bytes || bytes.length<=0)
         return null;

         String s=new String(bytes,DEFAULT_CHARSET);
         return  JSON.parseObject(s,aClass);
    }
}
