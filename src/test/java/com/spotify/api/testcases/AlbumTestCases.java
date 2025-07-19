package com.spotify.api.testcases;

import com.spotify.api.models.responses.albumservice.AlbumResponse;
import com.spotify.api.services.AlbumServices;
import com.spotify.api.util.JSONParser;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AlbumTestCases {
public void getAlbumDetails()
{
    String albumId="7ywJmodDrksHrxbnqHSDuT";

    AlbumServices albumServices=new AlbumServices();
    Response response= albumServices.getAlbum(albumId);

    System.out.println(response.asPrettyString());

}
@Test
    public void krishna()
    {
        String albumId="7ywJmodDrksHrxbnqHSDuT";

        AlbumServices albumServices=new AlbumServices();
        Response response= albumServices.getAlbum(albumId);

        System.out.println(response.asPrettyString());

        AlbumResponse albumResponse=JSONParser.parseObject(response, AlbumResponse.class);
        System.out.println(albumResponse.getTracks().getItems().get(1).getName());

    }
}

