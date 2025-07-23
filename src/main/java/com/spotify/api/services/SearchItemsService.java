package com.spotify.api.services;

import com.spotify.api.baseservice.BaseService;
import com.spotify.api.endpoints.SpotifyConstants;
import com.spotify.api.factory.RequestSpecificationFactory;
import com.spotify.api.models.requests.searchitems.SearchItemsRequestModel;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class SearchItemsService extends BaseService {
    public Response getAlbumID(SearchItemsRequestModel searchItemsRequestModel)
    {
        logger.info("Get album id from the search param {}" ,searchItemsRequestModel.toString());
        RequestSpecification specification= RequestSpecificationFactory
                .create()
                .withQueryParams(Map.of("q", searchItemsRequestModel.getQ(),
                        "type", searchItemsRequestModel.getType(),
                        "market", searchItemsRequestModel.getMarket(),
                        "limit", searchItemsRequestModel.getLimit()))
                .build();

        return getRequest(SpotifyConstants.SEARCH.toString(),specification);
    }
}
