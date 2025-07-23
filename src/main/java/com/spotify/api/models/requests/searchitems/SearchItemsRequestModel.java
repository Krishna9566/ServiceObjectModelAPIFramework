package com.spotify.api.models.requests.searchitems;

import lombok.Getter;

import java.util.List;

@Getter
public class SearchItemsRequestModel {

    private final String q;
    private final List<String> type;
    private final String market;
    private final Integer limit;
    private final Integer offset;


    public SearchItemsRequestModel(Builder builder) {
        this.q = builder.q;
        this.type = builder.type;
        this.market = builder.market;
        this.limit = builder.limit;
        this.offset = builder.offset;
    }
    public static class Builder
    {
        private String q;
        private List<String> type;
        private String market;
        private Integer limit;
        private Integer offset;

        public Builder setQ(String q) {
            this.q = q;
            return this;
        }

        public Builder setType(List<String> type) {
            this.type = type;
            return this;
        }

        public Builder setMarket(String market) {
            this.market = market;
            return this;
        }

        public Builder setLimit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder setOffset(Integer offset) {
            this.offset = offset;
            return this;
        }
        public SearchItemsRequestModel build() {
            return new SearchItemsRequestModel(this);
        }


    }
}
