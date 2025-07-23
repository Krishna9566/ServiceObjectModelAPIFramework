package com.spotify.api.wrappers;

import com.spotify.api.factory.ServiceFactory;
import com.spotify.api.services.AlbumServices;
import com.spotify.api.services.SearchItemsService;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static AlbumServices albumServices;
    protected static SearchItemsService searchItemsService;

    @BeforeClass
    public void initObjects() {
        albumServices = ServiceFactory.getAlbumServices();
        searchItemsService = ServiceFactory.getSearchItemsService();
    }
}
