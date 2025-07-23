package com.spotify.api.models.responses.searchservices;

import com.fasterxml.jackson.annotation.*;
import com.spotify.api.models.responses.albumservice.Artist;
import com.spotify.api.models.responses.albumservice.ExternalUrls;
import com.spotify.api.models.responses.albumservice.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "album_type",
        "total_tracks",
        "is_playable",
        "external_urls",
        "href",
        "id",
        "name",
        "release_date",
        "release_date_precision",
        "type",
        "uri",
        "artists",
})
public class Items {
    @JsonProperty("album_type")
    private String albumType;
    @JsonProperty("total_tracks")
    private Integer totalTracks;
    @JsonProperty("is_playable")
    private boolean isPlayable;
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
}
