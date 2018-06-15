package com.payments.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import static org.springframework.http.MediaType.TEXT_HTML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Feign client for fetching external data with dataId parameter of UUID type
 */
@FeignClient("mockbin")
public interface MockbinClient {

    @RequestMapping(path = "/bin/{dataId}", method = GET, produces = TEXT_HTML_VALUE)
    String getPayments(@PathVariable("dataId") UUID dataId);
}