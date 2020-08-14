package com.baosteel.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: HuYi.Zhang
 * @create: 2018-04-24 17:20
 **/
public class JsonUtils {

    public static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static String serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    public static <T> T parse(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <E> List<E> parseList(String json, Class<E> eClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <K, V> Map<K, V> parseMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static String parseObjToJson(Object obj) {
        String string = null;
        string = JSONObject.toJSONString(obj);
        return string;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class User{
        String name;
        Integer age;
    }
    public static void main(String[] args) {
        User user = new User("aa",21);
        String json = serialize(user);
        System.out.println(json);

        User user1 = parse(json,User.class);
        System.out.println(user1);

        String json1 = "[1,2,3,4,5]";
        List<Integer> list = parseList(json1,Integer.class);
        System.out.println(list);

        //language=JSON
        String json2 = "{\"name\": \"aa\", \"age\": 22}";
        Map<String ,String > map = parseMap(json2,String.class,String.class);
        System.out.println(map);

        String json3 = "[{\"name\": \"aa\", \"age\": 22},{\"name\": \"aa\", \"age\": 22},{\"name\": \"aa\", \"age\": 22}]";

        List<Map<String, String>> maps = nativeRead(json3, new TypeReference<List<Map<String, String>>>() {
        });
        for(Map<String ,String> map1 : maps) {
            System.out.println(map1);
        }
    }
}
