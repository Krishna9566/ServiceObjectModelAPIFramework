package com.spotify.api.services;

import com.spotify.api.baseservice.BaseService;
import com.spotify.api.endpoints.SpotifyConstants;
import com.spotify.api.util.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.time.Instant;
import java.util.Base64;

public class AuthServices extends BaseService{

    RequestSpecification requestSpecification;

    public AuthServices()
    {
        this.requestSpecification= RestAssured
                .given()
                .baseUri(SpotifyConstants.TOKEN_URL.toString());
    }

    public Response getAccessToken()
    {
        String basicAuth = Base64.getEncoder()
                .encodeToString((ConfigManager.INSTANCE.get("client_id") + ":" + ConfigManager.INSTANCE.get("client_secret")).getBytes());

        Response response = requestSpecification
                            .header("Authorization", "Basic " + basicAuth)
                            .contentType("application/x-www-form-urlencoded")
                            .formParam("grant_type", "refresh_token")
                            .formParam("refresh_token", ConfigManager.INSTANCE.get("refresh_token"))
                            .post();

        return response;
    }

}
