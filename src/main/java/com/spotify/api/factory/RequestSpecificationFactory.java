package com.spotify.api.factory;

import com.spotify.api.endpoints.SpotifyConstants;
import com.spotify.api.services.AlbumServices;
import com.spotify.api.util.TokenManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestSpecificationFactory{

    private final RequestSpecification specification;


    private RequestSpecificationFactory() {
        this.specification= RestAssured
                .given()
                .baseUri(SpotifyConstants.BASE_URI.toString())
                .header("Authorization", "Bearer " + TokenManager.getToken());
    }
    public static RequestSpecificationFactory create() {
        return new RequestSpecificationFactory();
    }
    public RequestSpecificationFactory withQueryParams(Map<String, Object> queryParams) {
        if (queryParams != null && !queryParams.isEmpty()) {
            specification.queryParams(queryParams);
        }
        return this;
    }
    public RequestSpecificationFactory withPathParams(Map<String, Object> pathParams) {
        if (pathParams != null && !pathParams.isEmpty()) {
            specification.pathParams(pathParams);
        }
        return this;
    }
    public RequestSpecificationFactory withHeaders(Map<String, String> headers) {
        if (headers != null && !headers.isEmpty()) {
            specification.headers(headers);
        }
        return this;
    }
    public RequestSpecification build() {
        return specification;
    }
}
