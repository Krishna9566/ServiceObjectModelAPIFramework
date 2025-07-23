package com.spotify.api.factory;

import com.spotify.api.services.AlbumServices;
import com.spotify.api.services.SearchItemsService;

public class ServiceFactory {

    private ServiceFactory() {
    }

    public static AlbumServices getAlbumServices() {
        return new AlbumServices();
    }
    public static SearchItemsService getSearchItemsService() {
        return new SearchItemsService();
    }
}
