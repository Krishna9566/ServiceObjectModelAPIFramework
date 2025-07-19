package com.spotify.api.baseservice;

import com.spotify.api.filters.LoggingFilters;
import com.spotify.api.util.LoggerUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;


public class BaseService {
    protected final Logger logger;

    public BaseService()
    {
        this.logger = LoggerUtil.getLogger(this.getClass());
    }

    static {
        RestAssured.filters(new LoggingFilters());
    }


    public Response getRequest(String url,RequestSpecification specification)
    {
        return specification
                .get(url);
    }






//    public RequestSpecification requestSpecification;

//    public BaseService()
//    {
//        this.requestSpecification= RestAssured
//                .given()
//                .baseUri(SpotifyConstants.BASE_URI.toString())
//                .header("Authorization", "Bearer " + TokenManager.getToken());
//    }

//    public Response getRequest(String url)
//    {
//        return requestSpecification
//                .get(url);
//    }
//    public Response getRequest(String url, Map<String,Object> pathParams)
//    {
//        if (pathParams != null && !pathParams.isEmpty()) {
//            requestSpecification.pathParams(pathParams);
//        }
//
//        return requestSpecification
//                .get(url);
//    }

//    public Response postRequest(Object payload, String url)
//    {
//        return requestSpecification
//                .header("Content-Type", "application/json")
//                .body(payload)
//                .post(url);
//    }
//    public Response putRequest(Object payload, String url)
//    {
//        return requestSpecification
//                .header("Content-Type", "application/json")
//                .body(payload)
//                .put(url);
//    }
}
