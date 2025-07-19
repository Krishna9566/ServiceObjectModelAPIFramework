package com.spotify.api.models.responses.albumservice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "album_type",
        "total_tracks",
        "available_markets",
        "external_urls",
        "href",
        "id",
        "images",
        "name",
        "release_date",
        "release_date_precision",
        "type",
        "uri",
        "artists",
        "tracks",
        "copyrights",
        "external_ids",
        "genres",
        "label",
        "popularity"
})
public class AlbumResponse {
    @JsonProperty("album_type")
    private String albumType;
    @JsonProperty("total_tracks")
    private Integer totalTracks;
    @JsonProperty("available_markets")
    private List<String> availableMarkets;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<Image> images;
    @JsonProperty("name")
    private String name;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("release_date_precision")
    private String releaseDatePrecision;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("artists")
    private List<Artist> artists;
    @JsonProperty("tracks")
    private Tracks tracks;
    @JsonProperty("copyrights")
    private List<Copyright> copyrights;
    @JsonProperty("external_ids")
    private ExternalIds externalIds;
    @JsonProperty("genres")
    private List<Object> genres;
    @JsonProperty("label")
    private String label;
    @JsonProperty("popularity")
    private Integer popularity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
}