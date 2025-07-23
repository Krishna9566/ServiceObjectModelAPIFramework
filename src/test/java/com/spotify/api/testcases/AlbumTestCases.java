package com.spotify.api.testcases;

import com.spotify.api.models.requests.searchitems.SearchItemsRequestModel;
import com.spotify.api.models.responses.albumservice.AlbumResponse;
import com.spotify.api.models.responses.searchservices.SearchResponse;
import com.spotify.api.services.AlbumServices;
import com.spotify.api.services.SearchItemsService;
import com.spotify.api.util.JSONParser;
import com.spotify.api.wrappers.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class AlbumTestCases extends BaseTest {
public void getAlbumDetails()
{
    String albumId="7ywJmodDrksHrxbnqHSDuT";

    AlbumServices albumServices=new AlbumServices();
    Response response= albumServices.getAlbum(albumId);

    System.out.println(response.asPrettyString());

}
@Test
public void searchAlbum()
{
    SearchItemsRequestModel searchItemsRequestModel= new SearchItemsRequestModel
            .Builder()
            .setLimit(1)
            .setMarket("IN")
            .setQ("Maryan")
            .setType(List.of("album"))
            .build();

    Response response= searchItemsService.getAlbumID(searchItemsRequestModel);

    System.out.println(response.asPrettyString());
    SearchResponse searchResponse=JSONParser.parseObject(response, SearchResponse.class);
    System.out.println(searchResponse.getAlbums().getItems().getFirst().getId());
    getTracksList(searchResponse.getAlbums().getItems().getFirst().getId());
}

    public static void getTracksList(String albumID)
    {
        Response response= albumServices.getAlbum(albumID);

        System.out.println(response.asPrettyString());

        AlbumResponse albumResponse=JSONParser.parseObject(response, AlbumResponse.class);
        System.out.println(albumResponse.getTracks().getItems().get(1).getName());

    }
}

