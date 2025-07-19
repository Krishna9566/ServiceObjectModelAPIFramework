package com.spotify.api.services;

import com.spotify.api.baseservice.BaseService;
import com.spotify.api.endpoints.SpotifyConstants;
import com.spotify.api.factory.RequestSpecificationFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class AlbumServices extends BaseService{

    public Response getAlbum(String albumId)
    {
        logger.info("Get album API started for the request {}" ,albumId);
        RequestSpecification specification= RequestSpecificationFactory
                .create()
                .withPathParams(Map.of("id", albumId))
                .build();

        return getRequest(SpotifyConstants.GET_ALBUM.toString(),specification);
    }
}
