package com.spotify.api.util;

import com.spotify.api.services.AuthServices;
import io.restassured.response.Response;

import java.time.Instant;

public class TokenManager{  //double checked singleton design pattern

        private static volatile String accessToken;
        private static volatile Instant expiryTime;
        private static final Object lock = new Object();

        public static String getToken() {
            if (accessToken == null || Instant.now().isAfter(expiryTime)) {
                synchronized (lock) {
                    if (accessToken == null || Instant.now().isAfter(expiryTime)) {
                        refreshAccessToken();
                    }
                }
            }
            return accessToken;
        }

        private static void refreshAccessToken() {
            AuthServices authServices=new AuthServices();
            Response response=authServices.getAccessToken();

            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed to refresh access token: " + response.asPrettyString());
            }

            System.out.println(response.asPrettyString());

            accessToken = response.jsonPath().getString("access_token");
            int expiresIn = response.jsonPath().getInt("expires_in");
            expiryTime = Instant.now().plusSeconds(expiresIn - 60);
        }
    }
