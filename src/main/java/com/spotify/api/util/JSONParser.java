package com.spotify.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.util.List;

public class JSONParser {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T parseObject(Response response, Class<T> className) {
        try {
            return response.as(className);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse object of type: " + className.getSimpleName(), e);
        }
    }

    public static <T> List<T> parseList(Response response, Class<T> className) {
        try {
            String json = response.asString();
            return mapper.readValue(
                    json,
                    mapper.getTypeFactory().constructCollectionType(List.class, className)
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse List<" + className.getSimpleName() + ">", e);
        }
    }
}
