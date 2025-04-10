package com.cakmak.abc.commons.feign;

import com.cakmak.abc.commons.web.GetAddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Halil Cakmak, Date : 2019-07-02
 */
@FeignClient("abc-billing-service")
public interface BillingFeignClient {

    @GetMapping("/address/{addressId}")
    GetAddressResponse getAddressById(@PathVariable("addressId") String addressId);

}
