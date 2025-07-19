package com.spotify.api.filters;

import com.spotify.api.util.LoggerUtil;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;

public class LoggingFilters implements Filter {

    private static final Logger logger = LoggerUtil.getLogger(LoggingFilters.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        requestLogging(filterableRequestSpecification);
        Response response=filterContext.next(filterableRequestSpecification,filterableResponseSpecification);
        responseLogging(response);

        return response;
    }
    public void requestLogging(FilterableRequestSpecification filterableRequestSpecification)
    {
        logger.info("Request URL :{}", filterableRequestSpecification.getURI());
        logger.info("Request Header :{}", filterableRequestSpecification.getHeaders());
        logger.info("Request Method :{}", filterableRequestSpecification.getMethod());
    }
    public void responseLogging(Response response)
    {
        logger.info("Response body :{}", response.getBody().asString());
        logger.info("Response Header :{}", response.getHeaders());
        logger.info("Response status code :{}", response.getStatusCode());
    }

}
