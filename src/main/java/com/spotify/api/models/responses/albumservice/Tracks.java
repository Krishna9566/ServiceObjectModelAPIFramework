package com.spotify.api.models.responses.albumservice;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
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
public class Tracks {
    @JsonProperty("href")
    private String href;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("next")
    private Object next;
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("previous")
    private Object previous;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("items")
    private List<Item> items;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

}
