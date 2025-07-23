package com.spotify.api.testcases;

import com.spotify.api.util.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GetRefreshToken {

        public static void main(String[] args) {// Replace with your actual code

            Map<String, String> params = new HashMap<>();
            params.put("grant_type", "authorization_code");
            params.put("code", ConfigManager.INSTANCE.get("auth_code"));
            params.put("redirect_uri", ConfigManager.INSTANCE.get("redirecturl"));
            params.put("client_id", ConfigManager.INSTANCE.get("client_id"));
            params.put("client_secret", ConfigManager.INSTANCE.get("client_secret"));

            // Send POST request to Spotify's token endpoint
            Response response = RestAssured.given()
                    .baseUri("https://accounts.spotify.com")
                    .contentType("application/x-www-form-urlencoded")
                    .formParams(params)
                    .when()
                    .post("/api/token");

            // Print response (contains access_token and refresh_token)
            System.out.println(response.getBody().asString());

            // Extract tokens
            String accessToken = response.jsonPath().getString("access_token");
            String refreshToken = response.jsonPath().getString("refresh_token");

            System.out.println("Access Token: " + accessToken);
            System.out.println("Refresh Token: " + refreshToken);
        }
    }
