package com.spotify.api.endpoints;

public enum SpotifyConstants {
    GET_ALBUM("albums/{id}"),
    SEARCH("search"),
    BASE_URI("https://api.spotify.com/v1/"),
    TOKEN_URL("https://accounts.spotify.com/api/token");

    private final String endpoint;

    SpotifyConstants(String endpoint) {
        this.endpoint = endpoint;
    }

    public String toString() {
        return endpoint;
    }
}
