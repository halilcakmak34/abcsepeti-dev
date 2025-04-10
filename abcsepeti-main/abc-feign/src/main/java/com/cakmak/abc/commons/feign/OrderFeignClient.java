package com.cakmak.abc.commons.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: Halil Cakmak, Date : 2019-07-02
 */
@FeignClient("abc-order-service")
public interface OrderFeignClient {


}
