package com.cakmak.abc.commons.feign;

import com.cakmak.abc.commons.web.GetProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Halil Cakmak,
 * Date : 2019-06-03
 */
@FeignClient("abc-catalog-service")
public interface CatalogFeignClient {

    @GetMapping("/product/{productId}")
    GetProductResponse getProduct(@PathVariable("productId") String productId);

}
