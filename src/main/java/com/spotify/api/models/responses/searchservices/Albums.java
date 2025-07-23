package com.spotify.api.models.responses.searchservices;

import com.fasterxml.jackson.annotation.*;
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
@NoArgsConstructor(force = true)
@AllArgsConstructor
@JsonPropertyOrder({
        "href",
        "limit",
        "next",
        "offset",
        "previous",
        "total",
        "items"
})
public class Albums {
    @JsonProperty("href")
    private final String href;
    @JsonProperty("limit")
    private final String limit;
    @JsonProperty("next")
    private final String next;
    @JsonProperty("offset")
    private final String offset;
    @JsonProperty("previous")
    private final String previous;
    @JsonProperty("total")
    private final String total;
    @JsonProperty("items")
    private final List<Items> items;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

}
